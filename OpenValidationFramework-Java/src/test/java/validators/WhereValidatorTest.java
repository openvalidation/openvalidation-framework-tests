package validators;

import org.bag.model.Thing;
import org.bag.model.ThingModel;
import org.bag.model.primitives.*;
import org.bag.openvalidation.HUMLFramework;
import org.bag.openvalidation.validator.ValidatorWhereFuncWithNumberCheck;
import org.bag.openvalidation.validator.ValidatorWhereSimpleNumberArray;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhereValidatorTest {
    
    @Test
    public void Where_object_equals_differentSourceFunc() {
        List<Thing> lst = new ArrayList<>();
        lst.add(new Thing(5, "five"));
        lst.add(new Thing(2, "two"));
        lst.add(new Thing(3, "three"));

        ThingModel model = new ThingModel();
        model.setThings(lst);

        ValidatorWhereFuncWithNumberCheck val = new ValidatorWhereFuncWithNumberCheck();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }
    
    @Test
    public void Where_object_not_equals_differentSourceFunc() {
        List<Thing> lst = new ArrayList<>();
        lst.add(new Thing(1, "one"));
        lst.add(new Thing(5, "five"));
        lst.add(new Thing(2, "two"));
        lst.add(new Thing(3, "three"));

        ThingModel model = new ThingModel();
        model.setThings(lst);

        ValidatorWhereFuncWithNumberCheck val = new ValidatorWhereFuncWithNumberCheck();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("anotherError"));
    }
    
    @Test
    public void Where_object_Func_On_SimpleNumberList() {
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);

        IntModel model = new IntModel();
        model.setIntList(lst);

        ValidatorWhereSimpleNumberArray val = ValidatorWhereSimpleNumberArray.createSimpleNumberListValidator();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }
    
    @Test
    public void Where_object_Func_On_SimpleNumberArray() {
        int[] arr = new int[]{1,2,3};

        IntModel model = new IntModel();
        model.setInts(arr);

        ValidatorWhereSimpleNumberArray val = ValidatorWhereSimpleNumberArray.createSimpleNumberArrayValidator();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }

    @Test
    public void Where_object_Func_On_SimpleBooleanArray() {
        boolean[] arr = new boolean[]{true,true,false};

        BooleanModel model = new BooleanModel();
        model.setBooleans(arr);
        model.setValue(true);

        ValidatorWhereSimpleNumberArray val = ValidatorWhereSimpleNumberArray.createSimpleBooleanValidator();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }

    @Test
    public void Where_object_Func_On_SimpleByteArray() {
        byte[] arr = new byte[]{1,2,3};

        ByteModel model = new ByteModel();
        model.setBytes(arr);
        model.setValue(Byte.valueOf("1"));

        ValidatorWhereSimpleNumberArray val = ValidatorWhereSimpleNumberArray.createSimpleByteValidator();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }

    @Test
    public void Where_object_Func_On_SimpleCharArray() {
        char[] arr = new char[]{'a','b','c'};

        CharModel model = new CharModel();
        model.setChars(arr);
        model.setValue('c');

        ValidatorWhereSimpleNumberArray val = ValidatorWhereSimpleNumberArray.createSimpleCharValidator();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }

    @Test
    public void Where_object_Func_On_SimpleDoubleArray() {
        double[] arr = new double[]{1.0,2.0,3.0};

        DoubleModel model = new DoubleModel();
        model.setDoubles(arr);
        model.setValue(2.0);

        ValidatorWhereSimpleNumberArray val = ValidatorWhereSimpleNumberArray.createSimpleDoubleValidator();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }

    @Test
    public void Where_object_Func_On_SimpleFloatArray() {
        float[] arr = new float[]{1.0f,2.0f,3.0f};

        FloatModel model = new FloatModel();
        model.setFloats(arr);
        model.setValue(2.0f);

        ValidatorWhereSimpleNumberArray val = ValidatorWhereSimpleNumberArray.createSimpleFloatValidator();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }

    @Test
    public void Where_object_Func_On_SimpleLongArray() {
        long[] arr = new long[]{1l,2l,3l};

        LongModel model = new LongModel();
        model.setLongs(arr);
        model.setValue(2l);

        ValidatorWhereSimpleNumberArray val = ValidatorWhereSimpleNumberArray.createSimpleLongValidator();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }

    @Test
    public void Where_object_Func_On_SimpleShortArray() {
        short[] arr = new short[]{1,2,3};

        ShortModel model = new ShortModel();
        model.setShorts(arr);
        model.setValue(Short.valueOf("3"));

        ValidatorWhereSimpleNumberArray val = ValidatorWhereSimpleNumberArray.createSimpleShortValidator();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }
    
    @Test
    public void Where_object_Func_On_SimpleNumberArray_NonPrimitive() {
        Integer[] arr = new Integer[]{1,2,3};

        IntModel model = new IntModel();
        model.setIntArray(arr);

        ValidatorWhereSimpleNumberArray val = ValidatorWhereSimpleNumberArray.createSimpleNumberArray_NonPrimitiveValidator();
        HUMLFramework.OpenValidationSummary result =  val.validate(model);

        assertThat(result, notNullValue());
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getErrors(), notNullValue());
        assertThat(result.getErrors().length, is(1));
        assertThat(result.getErrors()[0], notNullValue());
        assertThat(result.getErrors()[0].getError(), is("error"));
    }
}
