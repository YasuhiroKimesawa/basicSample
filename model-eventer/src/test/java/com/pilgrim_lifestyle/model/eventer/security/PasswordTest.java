package com.pilgrim_lifestyle.model.eventer.security;

import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import com.systemsekkei.base.test.model.BaseModelTest;

@RunWith( Enclosed.class )
public class PasswordTest extends BaseModelTest<Password>
{
    public static class 正常系  extends BaseModelTest<Password>
    {
        @Test
        public void パスワードが入力されていればエラーなし()
        {
            Password password = new Password( "!!assaa*" );
            password.toString();
            password.equals( password );
            password.hashCode();
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
                        PotentialAssignment.forValue( "２バイト", new Password( "あああああ" ) ),
                        PotentialAssignment.forValue( "カナ", new Password( "ｱｱｱｱｱ" ) )
                } );
            }
        }

        @Theory
        public void エラーになる( @ParametersSuppliedBy( PasswordSupplier.class ) Password password )
        {
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
                        PotentialAssignment.forValue( "3文字", new Password( "aaa" ) ),
                        PotentialAssignment.forValue( "9文字", new Password( "123456789" ) )
                } );
            }
        }

        @Theory
        public void エラーになる( @ParametersSuppliedBy( PasswordSupplier.class ) Password password )
        {
            validateAndAssert( "password", Length.class, password );
        }
    }

    public static class notest
    {
        Password password;

        @Before
        public void setup()
        {
            password = new Password();
        }

        @Test
        public void notests()
        {
            password.equals( null );
            password.equals( password );
            password.equals( new Password() );
            password.getPassword();
            password.setPassword( null );
            password.hashCode();
        }
    }

}
