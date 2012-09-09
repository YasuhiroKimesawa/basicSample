package com.pilgrim_lifestyle.model.eventer.personInfomation;

import java.util.Arrays;
import java.util.List;

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
            name = new PersonName( "１２３４５６７８９０１２", "１２３４５６７８９０１２" );
        }

        @Test
        public void エラーなし()
        {
            validateAndAssertCount( 0, name );
        }
    }

    public static class 空状態 extends BaseModelTest<PersonName>
    {
        PersonName lastNameEmpty;
        PersonName firstNameEmpty;

        @Before
        public void setup()
        {
            lastNameEmpty = new PersonName( "", "達也" );
            firstNameEmpty = new PersonName( "田中", "" );
        }

        @Test
        public void 空だとエラー()
        {
            validateAndAssert( "lastName", NotEmpty.class, lastNameEmpty );
            validateAndAssert( "firstName", NotEmpty.class, firstNameEmpty );
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

    public static class notest extends BaseModelTest<PersonName>
    {
        PersonName name;

        @Before
        public void setup()
        {
            name = new PersonName();
        }

        @Test
        public void notests()
        {
            name.equals( null );
            name.equals( name );
            name.equals( new PersonName() );
            name.getFirstName();
            name.getLastName();
            name.setFirstName( null );
            name.setLastName( null );
            name.hashCode();
        }
    }

}
