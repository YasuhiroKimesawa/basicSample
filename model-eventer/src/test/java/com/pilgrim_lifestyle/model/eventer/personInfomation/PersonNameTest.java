package com.pilgrim_lifestyle.model.eventer.personInfomation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
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

import com.pilgrim_lifestyle.model.eventer.EventerData;
import com.pilgrim_lifestyle.model.eventer.personInfomation.PersonName;
import com.systemsekkei.base.test.model.BaseModelTest;

@RunWith( Enclosed.class )
public class PersonNameTest extends BaseModelTest<PersonName>
{

    public static class エラーなし状態  extends BaseModelTest<PersonName>
    {
        PersonName name;

        @Before
        public void setup()
        {
            Map<EventerData, String> eventerData = new HashMap<EventerData, String>();
            eventerData.put( EventerData.姓, "１２３４５６７８９０１２" );
            eventerData.put( EventerData.名, "１２３４５６７８９０１２" );

            name = CreatingPersonalInfomation.instansOf( eventerData ).createPersonName();
        }

        @Test
        public void エラーなし()
        {
            validateAndAssertCount( 0, name );
        }
    }

    public static class 空状態 extends BaseModelTest<PersonName>
    {
        PersonName name;

        @Test
        public void 姓が空()
        {
            Map<EventerData, String> eventerData = new HashMap<EventerData, String>();
            eventerData.put( EventerData.姓, "" );
            eventerData.put( EventerData.名, "達也" );

            name = CreatingPersonalInfomation.instansOf( eventerData ).createPersonName();

            validateAndAssert( "lastName", NotEmpty.class, name );
        }

        @Test
        public void 名が空()
        {
            Map<EventerData, String> eventerData = new HashMap<EventerData, String>();
            eventerData.put( EventerData.姓, "田中" );
            eventerData.put( EventerData.名, "" );

            name = CreatingPersonalInfomation.instansOf( eventerData ).createPersonName();

            validateAndAssert( "lastName", NotEmpty.class, name );
        }
    }

    @RunWith( Theories.class )
    public static class 文字数が多い extends BaseModelTest<PersonName>
    {
        public static class LastNameSupplier extends ParameterSupplier
        {
            @Override
            public List<PotentialAssignment> getValueSources( ParameterSignature arg0 )
            {
                return Arrays.asList( new PotentialAssignment[]{
                        PotentialAssignment.forValue( "13文字小文字", new PersonName( "12345678901234", "達也" ) ),
                        PotentialAssignment.forValue( "13文字大文字", new PersonName( "１２３４５６７８９０１２３４", "達也" ) )
                } );
            }
        }

        public static class FirstNameSupplier extends ParameterSupplier
        {
            @Override
            public List<PotentialAssignment> getValueSources( ParameterSignature arg0 )
            {
                return Arrays.asList( new PotentialAssignment[]{
                        PotentialAssignment.forValue( "13文字小文字", new PersonName( "田中", "12345678901234" ) ),
                        PotentialAssignment.forValue( "13文字大文字", new PersonName( "田中", "１２３４５６７８９０１２３４" ) )
                } );
            }
        }

        @Theory
        public void 姓が14文字の場合はエラー( @ParametersSuppliedBy( LastNameSupplier.class ) PersonName personName )
        {
            validateAndAssert( "lastName", Length.class, personName );
        }

        @Theory
        public void 名が14文字の場合はエラー( @ParametersSuppliedBy( FirstNameSupplier.class ) PersonName personName )
        {
            validateAndAssert( "firstName", Length.class, personName );
        }
    }

}
