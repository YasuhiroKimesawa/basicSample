package com.pilgrim_lifestyle.model.eventer.personInfomation.contact;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.pilgrim_lifestyle.model.eventer.EventerData;
import com.pilgrim_lifestyle.model.eventer.personInfomation.contact.TelephoneNumber;
import com.systemsekkei.base.test.model.BaseModelTest;

@RunWith( Enclosed.class )
public class TelephoneNumberTest extends BaseModelTest<TelephoneNumber>
{
    public static class 空の場合と正常系 extends BaseModelTest<TelephoneNumber>
    {
        @Test
        public void 電話番号が空の場合はエラー()
        {
            Map<EventerData.Data, String> eventerData = new HashMap<EventerData.Data, String>();
            eventerData.put( EventerData.Data.電話番号, "" );

            TelephoneNumber telephoneNumber = CreatingContact.instansOf( eventerData ).createTelephoneNumber();

            validateAndAssert( "number", NotEmpty.class, telephoneNumber );

        }

        @Test
        public void 電話番号が正常の場合はエラーなし()
        {
            Map<EventerData.Data, String> eventerData = new HashMap<EventerData.Data, String>();
            eventerData.put( EventerData.Data.電話番号, "000-1111-2222" );

            TelephoneNumber telephoneNumber = CreatingContact.instansOf( eventerData ).createTelephoneNumber();

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
                        PotentialAssignment.forValue( "ハイフンがない", "090-11112222" ),
                        PotentialAssignment.forValue( "文字が入る", "亜90-1111-2222" ),
                        PotentialAssignment.forValue( "文字数が足りない", "1-2-3" )
                } );
            }
        }

        @Theory
        public void エラーになる( @ParametersSuppliedBy( TelephoneNumberSupplier.class ) String number )
        {
            Map<EventerData.Data, String> eventerData = new HashMap<EventerData.Data, String>();
            eventerData.put( EventerData.Data.電話番号, number );

            TelephoneNumber telephoneNumber = CreatingContact.instansOf( eventerData ).createTelephoneNumber();

            validateAndAssert( "number", Pattern.class, telephoneNumber );
        }
    }

}
