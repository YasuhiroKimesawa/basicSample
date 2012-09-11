package com.pilgrim_lifestyle.model.eventer.security;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import com.pilgrim_lifestyle.model.eventer.EventerData;
import com.systemsekkei.base.test.model.BaseModelTest;

@RunWith( Enclosed.class )
public class PasswordTest extends BaseModelTest<Password>
{
    public static class 正常系  extends BaseModelTest<Password>
    {
        @Test
        public void パスワードが入力されていればエラーなし()
        {
            Map<EventerData, String> eventerData = new HashMap<EventerData, String>();
            eventerData.put( EventerData.パスワード, "!!assaa*" );

            Password password = CreatingPasswords.instansOf( eventerData ).createPassword();

            validateAndAssertCount( 0, password );
        }
    }

    @RunWith( Theories.class )
    public static class パスワード形式がＮＧの場合 extends BaseModelTest<Password>
    {
        // テストデータ
        public static class PasswordSupplier extends ParameterSupplier
        {
            @Override
            public List<PotentialAssignment> getValueSources( ParameterSignature arg0 )
            {
                return Arrays.asList( new PotentialAssignment[]{
                        PotentialAssignment.forValue( "２バイト", "あああああ" ),
                        PotentialAssignment.forValue( "カナ", "ｱｱｱｱｱ" )
                } );
            }
        }

        @Theory
        public void エラーになる( @ParametersSuppliedBy( PasswordSupplier.class ) String pass )
        {
            Map<EventerData, String> eventerData = new HashMap<EventerData, String>();
            eventerData.put( EventerData.パスワード, pass );

            Password password = CreatingPasswords.instansOf( eventerData ).createPassword();

            validateAndAssert( "password", Pattern.class, password );
        }
    }

    @RunWith( Theories.class )
    public static class 文字数が4文字以下8文字以上の場合 extends BaseModelTest<Password>
    {
        // テストデータ
        public static class PasswordSupplier extends ParameterSupplier
        {
            @Override
            public List<PotentialAssignment> getValueSources( ParameterSignature arg0 )
            {
                return Arrays.asList( new PotentialAssignment[]{
                        PotentialAssignment.forValue( "3文字", "aaa" ),
                        PotentialAssignment.forValue( "9文字", "123456789" )
                } );
            }
        }

        @Theory
        public void エラーになる( @ParametersSuppliedBy( PasswordSupplier.class ) String pass )
        {
            Map<EventerData, String> eventerData = new HashMap<EventerData, String>();
            eventerData.put( EventerData.パスワード, pass );

            Password password = CreatingPasswords.instansOf( eventerData ).createPassword();

            validateAndAssert( "password", Length.class, password );
        }
    }

}
