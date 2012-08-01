package com.pilgrim_lifestyle.model.eventer.contact;

import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
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
public class TelephoneNumberTest extends BaseModelTest<TelephoneNumber>
{
    public static class 空の場合と正常系 extends BaseModelTest<TelephoneNumber>
    {
        @Test
        public void 電話番号が空の場合はエラー()
        {
            TelephoneNumber telephoneNumber = new TelephoneNumber( "" );
            validateAndAssert( "number", NotEmpty.class, telephoneNumber );

        }

        @Test
        public void 電話番号が正常の場合はエラーなし()
        {
            TelephoneNumber telephoneNumber = new TelephoneNumber( "000-1111-2222" );
            telephoneNumber.toString();

            validateAndAssertCount( 0, telephoneNumber );

        }
    }

    @RunWith( Theories.class )
    public static class 電話番号が不正の場合 extends BaseModelTest<TelephoneNumber>
    {
        // テストデータ
        public static class TelephoneNumberSupplier extends ParameterSupplier
        {
            @Override
            public List<PotentialAssignment> getValueSources( ParameterSignature arg0 )
            {
                return Arrays.asList( new PotentialAssignment[]{
                        PotentialAssignment.forValue( "ハイフンがない", new TelephoneNumber( "090-11112222" ) ),
                        PotentialAssignment.forValue( "文字が入る", new TelephoneNumber( "亜90-1111-2222" ) ),
                        PotentialAssignment.forValue( "文字数が足りない", new TelephoneNumber( "1-2-3" ) )
                } );
            }
        }

        @Theory
        public void エラーになる( @ParametersSuppliedBy( TelephoneNumberSupplier.class ) TelephoneNumber telephoneNumber )
        {
            validateAndAssert( "number", Pattern.class, telephoneNumber );
        }
    }

}
