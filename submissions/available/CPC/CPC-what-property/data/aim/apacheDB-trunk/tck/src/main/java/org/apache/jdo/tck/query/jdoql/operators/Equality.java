/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */
 
package org.apache.jdo.tck.query.jdoql.operators;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.jdo.tck.pc.fieldtypes.AllTypes;
import org.apache.jdo.tck.util.BatchTestRunner;

/**
 *<B>Title:</B> Equality Operator Support
 *<BR>
 *<B>Keywords:</B> query
 *<BR>
 *<B>Assertion ID:</B> A14.6.2-14.
 *<BR>
 *<B>Assertion Description: </B>
The equal operator (<code>==</code>) is supported for the following types:
<UL>
<LI><code>byte, short, int, long, char, Byte, Short Integer, Long, Character</code></LI>
<LI><code>float, double, Float, Double</code></LI>
<LI><code>BigDecimal, BigInteger</code></LI>
<LI><code>Boolean, boolean</code></LI>
<LI>any class instance or array</LI>
<LI><code>Date, String</code></LI>
</UL>
The operation on object-valued fields of wrapper types (<code>Boolean, Byte,
Short, Integer, Long, Float, and Double</code>), and numeric types
(<code>BigDecimal</code> and <code>BigInteger</code>) use the wrapped values
as operands. Equality comparison of object-valued fields of
<code>PersistenceCapable</code> types use the JDO Identity comparison
of the references. Thus, two objects will compare equal if they have the same
JDO Identity. Equality comparison of object-valued fields of
non-<code>PersistenceCapable</code> types uses the <code>equals</code>
method of the field type.

 */

public class Equality extends ComparisonTests {

    private static      String      boolean_filterL     = "value == fld_boolean";
    private static      String      boolean_filterR     = "fld_boolean == value";
    private static      String      boolean_filterT     = "fld_boolean == true";
    private static      String      boolean_filterF     = "false == fld_boolean";
    private static      String      boolean_filterObj   = "value.fld_boolean == fld_boolean";
    
    private static      String      byte_filterL        = "value == fld_byte";
    private static      String      byte_filterR        = "fld_byte == value";
    private static      String      byte_filterObj      = "value.fld_byte == fld_byte";
    private static      String      byte_filterVal      = "fld_byte == 100";
    
    private static      String      char_filterL        = "value == fld_char";
    private static      String      char_filterR        = "fld_char == value";
    private static      String      char_filterObj      = "value.fld_char == fld_char";
    private static      String      char_filterVal      = "'M' == fld_char";
    
    private static      String      double_filterL      = "value == fld_double";
    private static      String      double_filterR      = "fld_double == value";
    private static      String      double_filterObj    = "value.fld_double == fld_double";
    private static      String      double_filterVal    = "fld_double == 100.0";
    
    private static      String      float_filterL       = "value == fld_float";
    private static      String      float_filterR       = "fld_float == value";
    private static      String      float_filterObj     = "fld_float == value.fld_float";
    private static      String      float_filterVal     = "fld_float == 100.0";
    
    private static      String      int_filterL         = "value == fld_int";
    private static      String      int_filterR         = "fld_int == value";
    private static      String      int_filterObj       = "value.fld_int == fld_int";
    private static      String      int_filterVal       = "fld_int == 1000";
    
    private static      String      long_filterL        = "value == fld_long";
    private static      String      long_filterR        = "fld_long == value";
    private static      String      long_filterObj      = "fld_long == value.fld_long";
    private static      String      long_filterVal      = "fld_long == 1000000";
    
    private static      String      short_filterL       = "value == fld_short";
    private static      String      short_filterR       = "fld_short == value";
    private static      String      short_filterObj     = "value.fld_short == fld_short";
    private static      String      short_filterVal     = "1000 == fld_short";
    
    private static      String      Boolean_filterL     = "value == fld_Boolean";
    private static      String      Boolean_filterR     = "fld_Boolean == value";
    private static      String      Boolean_filterT     = "fld_Boolean == true";
    private static      String      Boolean_filterF     = "false == fld_Boolean";
    private static      String      Boolean_filterObj   = "value.fld_Boolean == fld_Boolean";
    private static      String      Boolean_filterVal   = "fld_Boolean == false";
    
    private static      String      Byte_filterL        = "value == fld_Byte";
    private static      String      Byte_filterR        = "fld_Byte == value";
    private static      String      Byte_filterObj      = "fld_Byte == value.fld_Byte";
    private static      String      Byte_filterVal      = "100 == fld_Byte";
    
    private static      String      Character_filterL   = "value == fld_Character";
    private static      String      Character_filterR   = "fld_Character == value";
    private static      String      Character_filterObj = "value.fld_Character == fld_Character";
    private static      String      Character_filterVal = "fld_Character == 'z'";
    
    private static      String      Double_filterL      = "value == fld_Double";
    private static      String      Double_filterR      = "fld_Double == value";
    private static      String      Double_filterObj    = "value.fld_Double == fld_Double";
    private static      String      Double_filterVal    = "fld_Double == -25.5";
    
    private static      String      Float_filterL       = "value == fld_Float";
    private static      String      Float_filterR       = "fld_Float == value";
    private static      String      Float_filterObj     = "fld_Float == value.fld_Float";
    private static      String      Float_filterVal     = "100.0f == fld_Float";
    
    private static      String      Integer_filterL     = "value == fld_Integer";
    private static      String      Integer_filterR     = "fld_Integer == value";
    private static      String      Integer_filterObj   = "fld_Integer == value.fld_Integer";
    private static      String      Integer_filterVal   = "fld_Integer == 100";
    
    private static      String      Long_filterL        = "value == fld_Long";
    private static      String      Long_filterR        = "fld_Long == value";
    private static      String      Long_filterObj      = "value.fld_Long == fld_Long";
    private static      String      Long_filterVal      = "-1000 == fld_Long";
    
    private static      String      Short_filterL       = "value == fld_Short";
    private static      String      Short_filterR       = "fld_Short == value";
    private static      String      Short_filterObj     = "fld_Short == value.fld_Short";
    private static      String      Short_filterVal     = "-1000 == fld_Short";
    
    private static      String      String_filterL      = "value == fld_String";
    private static      String      String_filterR      = "fld_String == value";
    private static      String      String_filterObj    = "value.fld_String == fld_String";
    private static      String      String_filterVal1   = "fld_String == \"Java\"";
    private static      String      String_filterVal2   = "fld_String == \"\"";
    
    private static      String      Locale_filterL      = "value == fld_Locale";
    private static      String      Locale_filterR      = "fld_Locale == value";
    private static      String      Locale_filterObj    = "value.fld_Locale == fld_Locale";

    private static      String      Date_filterL        = "value == fld_Date";
    private static      String      Date_filterR        = "fld_Date == value";
    private static      String      Date_filterObj      = "fld_Date == value.fld_Date";
    
    private static      String      BigDecimal_filterL  = "value == fld_BigDecimal";
    private static      String      BigDecimal_filterR  = "fld_BigDecimal == value";
    private static      String      BigDecimal_filterObj = "value.fld_BigDecimal == fld_BigDecimal";
    
    private static      String      BigInteger_filterL  = "value == fld_BigInteger";
    private static      String      BigInteger_filterR  = "fld_BigInteger == value";
    private static      String      BigInteger_filterObj = "fld_BigInteger == value.fld_BigInteger";

    /** */
    private static final String ASSERTION_FAILED = 
        "Assertion A14.6.2-14 (Equality) failed: ";

    /**
     * The <code>main</code> is called when the class
     * is directly executed from the command line.
     * @param args The arguments passed to the program.
     */
    public static void main(String[] args) {
        BatchTestRunner.run(Equality.class);
    }

    /** */
    public void test() {
        pm = getPM();
        tx = pm.currentTransaction();
        runQueries();
    }

    /** */
    private void runQueries()
    {
        run_booleanQuery(boolean_filterL, booleanParameter, Boolean.TRUE, true, 4);
        run_booleanQuery(boolean_filterL, booleanParameter, Boolean.FALSE, false, 6);
        run_booleanQuery(boolean_filterR, booleanParameter, Boolean.TRUE, true, 4);
        run_booleanQuery(boolean_filterR, booleanParameter, Boolean.FALSE, false, 6);
        run_booleanQuery(boolean_filterL, BooleanParameter, Boolean.TRUE, true, 4);
        run_booleanQuery(boolean_filterL, BooleanParameter, Boolean.FALSE, false, 6);
        run_booleanQuery(boolean_filterR, BooleanParameter, Boolean.TRUE, true, 4);
        run_booleanQuery(boolean_filterR, BooleanParameter, Boolean.FALSE, false, 6);
        run_booleanQuery(boolean_filterT, null, null, true, 4);
        run_booleanQuery(boolean_filterF, null, null, false, 6);
        AllTypes alltypes = new AllTypes();
        alltypes.setboolean(true);
        run_booleanQuery(boolean_filterObj, AllTypesParameter, alltypes, true, 4);
        alltypes.setboolean(false);
        run_booleanQuery(boolean_filterObj, AllTypesParameter, alltypes, false, 6);

        run_byteQuery(byte_filterL, byteParameter, new Byte((byte)50), (byte)50, 2);
        run_byteQuery(byte_filterR, byteParameter, new Byte(Byte.MIN_VALUE), Byte.MIN_VALUE, 1);
        run_byteQuery(byte_filterL, ByteParameter, new Byte((byte)20), (byte)20, 0);
        run_byteQuery(byte_filterR, ByteParameter, new Byte(Byte.MAX_VALUE), Byte.MAX_VALUE, 1);    
        run_byteQuery(byte_filterL, shortParameter, new Short((short)50), (byte)50, 2);
        run_byteQuery(byte_filterR, shortParameter, new Short((short)50), (byte)50, 2);
        run_byteQuery(byte_filterL, ShortParameter, new Short((short)-100), (byte)-100, 1);
        run_byteQuery(byte_filterR, ShortParameter, new Short((short)-100), (byte)-100, 1);
        run_byteQuery(byte_filterL, charParameter, new Character((char)50), (byte)50, 2);
        run_byteQuery(byte_filterR, charParameter, new Character((char)50), (byte)50, 2);
        run_byteQuery(byte_filterL, CharacterParameter, new Character((char)50), (byte)50, 2);
        run_byteQuery(byte_filterR, CharacterParameter, new Character((char)100), (byte)100, 1);    
        run_byteQuery(byte_filterL, intParameter, new Integer(50), (byte)50, 2);
        run_byteQuery(byte_filterR, intParameter, new Integer(50), (byte)50, 2);
        run_byteQuery(byte_filterL, IntegerParameter, new Integer(-100), (byte)-100, 1);
        run_byteQuery(byte_filterR, IntegerParameter, new Integer(-100), (byte)-100, 1);
        run_byteQuery(byte_filterL, longParameter, new Long(50), (byte)50, 2);
        run_byteQuery(byte_filterR, longParameter, new Long(50), (byte)50, 2);
        run_byteQuery(byte_filterL, LongParameter, new Long(-100), (byte)-100, 1);
        run_byteQuery(byte_filterR, LongParameter, new Long(-100), (byte)-100, 1);
        run_byteQuery(byte_filterL, floatParameter, new Float(50.0f), (byte)50, 2);
        run_byteQuery(byte_filterR, floatParameter, new Float(50.0f), (byte)50, 2);
        run_byteQuery(byte_filterL, FloatParameter, new Float(-100.0f), (byte)-100, 1);
        run_byteQuery(byte_filterR, FloatParameter, new Float(-100.0f), (byte)-100, 1);
        run_byteQuery(byte_filterL, doubleParameter, new Double(50.0), (byte)50, 2);
        run_byteQuery(byte_filterR, doubleParameter, new Double(50.0), (byte)50, 2);
        run_byteQuery(byte_filterL, DoubleParameter, new Double(-100.0), (byte)-100, 1);
        run_byteQuery(byte_filterR, DoubleParameter, new Double(-100.0), (byte)-100, 1);
        run_byteQuery(byte_filterL, BigIntegerParameter, new BigInteger("50"), (byte)50, 2);
        run_byteQuery(byte_filterR, BigIntegerParameter, new BigInteger("-100"), (byte)-100, 1);
        run_byteQuery(byte_filterL, BigDecimalParameter, new BigDecimal("100.0"), (byte)100, 1);
        run_byteQuery(byte_filterR, BigDecimalParameter, new BigDecimal("10.0"), (byte)10, 1);    
        alltypes.setbyte((byte)50);
        run_byteQuery(byte_filterObj, AllTypesParameter, alltypes, (byte)50, 2);
        alltypes.setbyte((byte)45);
        run_byteQuery(byte_filterObj, AllTypesParameter, alltypes, (byte)45, 0);
        run_byteQuery(byte_filterVal, null, null, (byte)100, 1);

        run_shortQuery(short_filterL, shortParameter, new Short((short)100), (short)100, 2);
        run_shortQuery(short_filterR, shortParameter, new Short((short)100), (short)100, 2);
        run_shortQuery(short_filterL, ShortParameter, new Short(Short.MIN_VALUE), Short.MIN_VALUE, 1);
        run_shortQuery(short_filterR, ShortParameter, new Short((short)253), (short)253, 0);
        run_shortQuery(short_filterR, shortParameter, new Short((short)1000), (short)1000, 1);
        run_shortQuery(short_filterL, byteParameter, new Byte((byte)75), (short)75, 0);
        run_shortQuery(short_filterR, byteParameter, new Byte((byte)75), (short)75, 0);
        run_shortQuery(short_filterL, ByteParameter, new Byte((byte)100), (short)100, 2);
        run_shortQuery(short_filterR, ByteParameter, new Byte((byte)100), (short)100, 2);
        run_shortQuery(short_filterL, charParameter, new Character((char)75), (short)75, 0);
        run_shortQuery(short_filterR, charParameter, new Character((char)75), (short)75, 0);
        run_shortQuery(short_filterL, CharacterParameter, new Character((char)100), (short)100, 2);
        run_shortQuery(short_filterR, CharacterParameter, new Character((char)100), (short)100, 2);
        run_shortQuery(short_filterL, intParameter, new Integer(-10000), (short)-10000, 1);
        run_shortQuery(short_filterR, intParameter, new Integer(-10000), (short)-10000, 1);
        run_shortQuery(short_filterL, IntegerParameter, new Integer(10000), (short)10000, 1);
        run_shortQuery(short_filterR, IntegerParameter, new Integer(10000), (short)10000, 1);
        run_shortQuery(short_filterL, longParameter, new Long(10000), (short) 10000, 1);
        run_shortQuery(short_filterR, longParameter, new Long(10000), (short) 10000, 1);
        run_shortQuery(short_filterL, LongParameter, new Long(100), (short)100, 2);
        run_shortQuery(short_filterR, LongParameter, new Long(100), (short)100, 2);
        run_shortQuery(short_filterL, floatParameter, new Float(23000), (short)23000, 0);
        run_shortQuery(short_filterR, floatParameter, new Float(23000), (short)23000, 0);
        run_shortQuery(short_filterL, FloatParameter, new Float(100), (short)100, 2);
        run_shortQuery(short_filterR, FloatParameter, new Float(100), (short)100, 2);
        run_shortQuery(short_filterL, doubleParameter, new Double(-10000), (short)-10000, 1);
        run_shortQuery(short_filterR, doubleParameter, new Double(-10000), (short)-10000, 1);
        run_shortQuery(short_filterL, DoubleParameter, new Double(23), (short)23, 0);
        run_shortQuery(short_filterR, DoubleParameter, new Double(23), (short)23, 0);
        run_shortQuery(short_filterL, BigIntegerParameter, new BigInteger("999"), (short)999, 0);
        run_shortQuery(short_filterR, BigIntegerParameter, new BigInteger("-1000"), (short)-1000, 1);
        run_shortQuery(short_filterL, BigDecimalParameter, new BigDecimal("100.0"), (short)100, 2);
        run_shortQuery(short_filterR, BigDecimalParameter, new BigDecimal("100.0001"), (short)100, 0);    
        alltypes.setshort((short)100);
        run_shortQuery(short_filterObj, AllTypesParameter, alltypes, (short)100, 2);
        alltypes.setshort((short)23);
        run_shortQuery(short_filterObj, AllTypesParameter, alltypes, (short)23, 0);
        run_shortQuery(short_filterVal, null, null, (short)1000, 1);
    
        run_charQuery(char_filterL, charParameter, new Character(Character.MIN_VALUE), Character.MIN_VALUE, 1);
        run_charQuery(char_filterR, charParameter, new Character(Character.MAX_VALUE), Character.MAX_VALUE, 1);
        run_charQuery(char_filterL, charParameter, new Character('C'), 'C', 0);
        run_charQuery(char_filterR, charParameter, new Character('z'), 'z', 2);
        run_charQuery(char_filterL, CharacterParameter, new Character(' '), ' ', 1);
        run_charQuery(char_filterR, CharacterParameter, new Character('f'), 'f', 0);
        run_charQuery(char_filterL, byteParameter, new Byte((byte)Character.MIN_VALUE), (char)Character.MIN_VALUE, 1);
        run_charQuery(char_filterR, byteParameter, new Byte((byte)122), 'z', 2);
        run_charQuery(char_filterL, ByteParameter, new Byte((byte)'a'), 'a', 0);
        run_charQuery(char_filterR, ByteParameter, new Byte((byte)'a'), 'a', 0);
        run_charQuery(char_filterL, shortParameter, new Short((short)'M'), 'M', 2);
        run_charQuery(char_filterR, shortParameter, new Short((short)'M'), 'M', 2);
        run_charQuery(char_filterL, ShortParameter, new Short((short)'A'), 'A', 1);
        run_charQuery(char_filterR, ShortParameter, new Short((short)'A'), 'A', 1);
        run_charQuery(char_filterL, intParameter, new Integer('z'), 'z', 2);
        run_charQuery(char_filterR, intParameter, new Integer('z'), 'z', 2);
        run_charQuery(char_filterL, IntegerParameter, new Integer('B'), 'B', 1);
        run_charQuery(char_filterR, IntegerParameter, new Integer('B'), 'B', 1);
        run_charQuery(char_filterL, longParameter, new Long('z'), 'z', 2);
        run_charQuery(char_filterR, longParameter, new Long('z'), 'z', 2);
        run_charQuery(char_filterL, LongParameter, new Long('B'), 'B', 1);
        run_charQuery(char_filterR, LongParameter, new Long('B'), 'B', 1);
        run_charQuery(char_filterL, floatParameter, new Float(123.222), 'x', 0);
        run_charQuery(char_filterR, floatParameter, new Float(123.222), 'x', 0);
        run_charQuery(char_filterL, FloatParameter, new Float('z'), 'z', 2);
        run_charQuery(char_filterR, FloatParameter, new Float('z'), 'z', 2);
        run_charQuery(char_filterL, doubleParameter, new Double('B'), 'B', 1);
        run_charQuery(char_filterR, doubleParameter, new Double('B'), 'B', 1);
        run_charQuery(char_filterL, DoubleParameter, new Double('A'), 'A', 1);
        run_charQuery(char_filterR, DoubleParameter, new Double('A'), 'A', 1);
        run_charQuery(char_filterL, BigIntegerParameter, new BigInteger("65"), 'A', 1);   // 'A' == 65
        run_charQuery(char_filterR, BigIntegerParameter, new BigInteger("122"), 'z', 2);  // 'z' == 122
        run_charQuery(char_filterL, BigDecimalParameter, new BigDecimal("65.0"), 'A', 1);
        run_charQuery(char_filterR, BigDecimalParameter, new BigDecimal("77.0"), 'M', 2); // 'M' == 77
        alltypes.setchar('A');
        run_charQuery(char_filterObj, AllTypesParameter, alltypes, 'A', 1);
        alltypes.setchar('b');
        run_charQuery(char_filterObj, AllTypesParameter, alltypes, 'b', 0);
        run_charQuery(char_filterVal, null, null, 'M', 2);
    
        run_intQuery(int_filterL, intParameter, new Integer(AllTypes.veryLargeNegativeInt), AllTypes.veryLargeNegativeInt, 1);
        run_intQuery(int_filterR, intParameter, new Integer(AllTypes.veryLargePositiveInt), AllTypes.veryLargePositiveInt, 1);
        run_intQuery(int_filterR, intParameter, new Integer(23), 23, 0);
        run_intQuery(int_filterL, IntegerParameter, new Integer(1000000), 1000000, 1);
        run_intQuery(int_filterR, IntegerParameter, new Integer(1000), 1000, 1);
        run_intQuery(int_filterL, byteParameter, new Byte((byte)100), 100, 2);
        run_intQuery(int_filterR, byteParameter, new Byte((byte)0), 0, 1);
        run_intQuery(int_filterL, ByteParameter, new Byte((byte)100), 100, 2);
        run_intQuery(int_filterR, ByteParameter, new Byte((byte)0), 0, 1);
        run_intQuery(int_filterL, shortParameter, new Short((short)10000), 10000, 1);
        run_intQuery(int_filterR, shortParameter, new Short((short)-1000), -1000, 1);
        run_intQuery(int_filterL, ShortParameter, new Short((short)-1000), -1000, 1);
        run_intQuery(int_filterR, ShortParameter, new Short((short)10000), 10000, 1);
        run_intQuery(int_filterL, charParameter, new Character((char)10000), 10000, 1);
        run_intQuery(int_filterR, charParameter, new Character((char)0), 0, 1);
        run_intQuery(int_filterL, CharacterParameter, new Character((char)100), 100, 2);
        run_intQuery(int_filterR, CharacterParameter, new Character((char)10000), 10000, 1);
        run_intQuery(int_filterL, longParameter, new Long(AllTypes.veryLargePositiveInt), AllTypes.veryLargePositiveInt, 1);
        run_intQuery(int_filterR, longParameter, new Long(AllTypes.veryLargeNegativeInt), AllTypes.veryLargeNegativeInt, 1);
        run_intQuery(int_filterL, LongParameter, new Long(10000), 10000, 1);
        run_intQuery(int_filterR, LongParameter, new Long(43), 43, 0);
        run_intQuery(int_filterL, floatParameter, new Float(AllTypes.veryLargePositiveInt), AllTypes.veryLargePositiveInt, 1);
        run_intQuery(int_filterR, floatParameter, new Float(AllTypes.veryLargeNegativeInt), AllTypes.veryLargeNegativeInt, 1);
        run_intQuery(int_filterL, FloatParameter, new Float(10000), 10000, 1);
        run_intQuery(int_filterR, FloatParameter, new Float(43), 43, 0);
        run_intQuery(int_filterL, doubleParameter, new Double(AllTypes.veryLargePositiveInt), AllTypes.veryLargePositiveInt, 1);
        run_intQuery(int_filterR, doubleParameter, new Double(AllTypes.veryLargeNegativeInt), AllTypes.veryLargeNegativeInt, 1);
        run_intQuery(int_filterL, DoubleParameter, new Double(10000), 10000, 1);
        run_intQuery(int_filterR, DoubleParameter, new Double(43), 43, 0);
        run_intQuery(int_filterL, BigIntegerParameter, new BigInteger("1000000"), 1000000, 1);
        run_intQuery(int_filterR, BigIntegerParameter, new BigInteger("-1000000"), -1000000, 1);
        run_intQuery(int_filterL, BigDecimalParameter, new BigDecimal("1000000.0"), 1000000, 1);
        run_intQuery(int_filterR, BigDecimalParameter, new BigDecimal("-1000000.00001"), -1000000, 0);
        alltypes.setint(100);
        run_intQuery(int_filterObj, AllTypesParameter, alltypes, 100, 2);
        run_intQuery(int_filterVal, null, null, 1000, 1);
    
        run_longQuery(long_filterL, longParameter, new Long(Long.MIN_VALUE), Long.MIN_VALUE, 1);
        run_longQuery(long_filterR, longParameter, new Long(Long.MAX_VALUE), Long.MAX_VALUE, 1);
        run_longQuery(long_filterL, LongParameter, new Long(100), 100, 2);
        run_longQuery(long_filterR, LongParameter, new Long(23), 23, 0);
        run_longQuery(long_filterL, byteParameter, new Byte((byte)100), 100, 2);
        run_longQuery(long_filterR, byteParameter, new Byte((byte)0), 0, 1);
        run_longQuery(long_filterL, ByteParameter, new Byte((byte)100), 100, 2);
        run_longQuery(long_filterR, ByteParameter, new Byte((byte)0), 0, 1);
        run_longQuery(long_filterL, shortParameter, new Short((short)-1000 ), -1000, 2);
        run_longQuery(long_filterR, shortParameter, new Short((short)1000), 1000, 1);
        run_longQuery(long_filterL, ShortParameter, new Short((short)100), 100, 2);
        run_longQuery(long_filterR, ShortParameter, new Short((short)32), 32, 0);
        run_longQuery(long_filterL, charParameter, new Character((char)0), 0, 1);
        run_longQuery(long_filterR, charParameter, new Character((char)100), 100, 2);
        run_longQuery(long_filterL, CharacterParameter, new Character((char)23), 23, 0);
        run_longQuery(long_filterR, CharacterParameter, new Character((char)0), 0, 1);
        run_longQuery(long_filterL, intParameter, new Integer(100), 100, 2);
        run_longQuery(long_filterR, intParameter, new Integer(0), 0, 1);
        run_longQuery(long_filterL, IntegerParameter, new Integer(23), 23, 0);
        run_longQuery(long_filterR, IntegerParameter, new Integer(1000000), 1000000, 1);
        run_longQuery(long_filterL, floatParameter, new Float(-1000000.0), -1000000, 1);
//    run_longQuery(long_filterR, floatParameter, new Float((float)Long.MAX_VALUE), Long.MAX_VALUE, 1);
        run_longQuery(long_filterL, FloatParameter, new Float(100), 100, 2);
        run_longQuery(long_filterR, FloatParameter, new Float(32), 32, 0);
        run_longQuery(long_filterL, doubleParameter, new Double(-1000000.0), -1000000, 1);
//    run_longQuery(long_filterR, doubleParameter, new Double((double)Long.MAX_VALUE), Long.MAX_VALUE, 1);
        run_longQuery(long_filterL, DoubleParameter, new Double(100.0), 100, 2);
        run_longQuery(long_filterR, DoubleParameter, new Double(32.0), 32, 0);
        run_longQuery(long_filterL, BigIntegerParameter, new BigInteger("1000000"), 1000000, 1);
        run_longQuery(long_filterR, BigIntegerParameter, new BigInteger("-1000000"), -1000000, 1);
        run_longQuery(long_filterL, BigDecimalParameter, new BigDecimal("100.0"), 100, 2);
        run_longQuery(long_filterR, BigDecimalParameter, new BigDecimal("-1000000.0001"), -1000000, 0);
        alltypes.setlong(100);
        run_longQuery(long_filterObj, AllTypesParameter, alltypes, 100, 2);
        run_longQuery(long_filterVal, null, null, 1000000, 1);
    
        run_floatQuery(float_filterL, floatParameter, new Float(-234.23f), -234.23f, 1);
        run_floatQuery(float_filterR, floatParameter, new Float(-234.23f), -234.23f, 1);
        run_floatQuery(float_filterL, FloatParameter, new Float(0.0), 0.0f, 1);
        run_floatQuery(float_filterR, FloatParameter, new Float(4.0), 4.0f, 0);
        run_floatQuery(float_filterL, byteParameter, new Byte((byte)0), 0.0f, 1);
        run_floatQuery(float_filterR, byteParameter, new Byte((byte)23), 23.0f, 0);
        run_floatQuery(float_filterL, ByteParameter, new Byte((byte)34), 34.0f, 0);
        run_floatQuery(float_filterR, ByteParameter, new Byte((byte)100), 100.0f, 2);
        run_floatQuery(float_filterL, shortParameter, new Short((short)0), 0.0f, 1);
        run_floatQuery(float_filterR, shortParameter, new Short((short)23), 23.0f, 0);
        run_floatQuery(float_filterL, ShortParameter, new Short((short)34), 34.0f, 0);
        run_floatQuery(float_filterR, ShortParameter, new Short((short)100), 100.0f, 2);
        run_floatQuery(float_filterL, charParameter, new Character((char)0), 0.0f, 1);
        run_floatQuery(float_filterR, charParameter, new Character((char)23), 23.0f, 0);
        run_floatQuery(float_filterL, CharacterParameter, new Character((char)34), 34.0f, 0);
        run_floatQuery(float_filterR, CharacterParameter, new Character((char)100), 100.0f, 2);
        run_floatQuery(float_filterL, intParameter, new Integer(50000000), 50000000.0f, 1);
        run_floatQuery(float_filterR, intParameter, new Integer(23), 23.0f, 0);
        run_floatQuery(float_filterL, IntegerParameter, new Integer(34), 34.0f, 0);
        run_floatQuery(float_filterR, IntegerParameter, new Integer(100), 100.0f, 2);
        run_floatQuery(float_filterL, longParameter, new Long(50000000), 50000000.0f, 1);
        run_floatQuery(float_filterR, longParameter, new Long(23), 23.0f, 0);
        run_floatQuery(float_filterL, LongParameter, new Long(34), 34.0f, 0);
        run_floatQuery(float_filterR, LongParameter, new Long(100), 100.0f, 2);
        run_floatQuery(float_filterL, doubleParameter, new Double(50000000.0), 50000000.0f, 1);
        run_floatQuery(float_filterR, doubleParameter, new Double(-25.5), -25.5f, 1);
        run_floatQuery(float_filterL, DoubleParameter, new Double(0.0), 0.0f, 1);
        run_floatQuery(float_filterR, DoubleParameter, new Double(100.0), 100.0f, 2);
        run_floatQuery(float_filterL, BigIntegerParameter, new BigInteger("0"), 0.0f, 1);
        run_floatQuery(float_filterR, BigIntegerParameter, new BigInteger("1000000000"), 1000000000.0f, 1);
        run_floatQuery(float_filterL, BigDecimalParameter, new BigDecimal("350.5"), 350.5f, 1);
        run_floatQuery(float_filterR, BigDecimalParameter, new BigDecimal("50000000.0"), 50000000.0f, 1);
        alltypes.setfloat(23.23f);
        run_floatQuery(float_filterObj, AllTypesParameter, alltypes, 23.23f, 0);
        run_floatQuery(float_filterVal, null, null, 100.0f, 2);
    
        run_doubleQuery(double_filterL, doubleParameter, new Double(-234234.234), -234234.234, 1);
        run_doubleQuery(double_filterR, doubleParameter, new Double(-234234.234), -234234.234, 1);
        run_doubleQuery(double_filterL, DoubleParameter, new Double(0.0), 0.0, 1);
        run_doubleQuery(double_filterR, DoubleParameter, new Double(23.34), 23.34, 0);
        run_doubleQuery(double_filterL, byteParameter, new Byte((byte)100), 100.0, 2);
        run_doubleQuery(double_filterR, byteParameter, new Byte((byte)0), 0.0, 1);
        run_doubleQuery(double_filterL, ByteParameter, new Byte((byte)23), 23.0, 0);
        run_doubleQuery(double_filterR, ByteParameter, new Byte((byte)100), 100.0, 2);
        run_doubleQuery(double_filterL, shortParameter, new Short((short)100), 100.0, 2);
        run_doubleQuery(double_filterR, shortParameter, new Short((short)0), 0.0, 1);
        run_doubleQuery(double_filterL, ShortParameter, new Short((short)23), 23.0, 0);
        run_doubleQuery(double_filterR, ShortParameter, new Short((short)100), 100.0, 2);
        run_doubleQuery(double_filterL, intParameter, new Integer(100), 100.0, 2);
        run_doubleQuery(double_filterR, intParameter, new Integer(0), 0.0, 1);
        run_doubleQuery(double_filterL, IntegerParameter, new Integer(23), 23.0, 0);
        run_doubleQuery(double_filterR, IntegerParameter, new Integer(100), 100.0, 2);
        run_doubleQuery(double_filterL, longParameter, new Long(100), 100.0, 2);
        run_doubleQuery(double_filterR, longParameter, new Long(0), 0.0, 1);
        run_doubleQuery(double_filterL, LongParameter, new Long(23), 23.0, 0);
        run_doubleQuery(double_filterR, LongParameter, new Long(100), 100.0, 2);
        run_doubleQuery(double_filterL, floatParameter, new Float(0.0f),0.0f, 1);
        run_doubleQuery(double_filterR, floatParameter, new Float(100.0f), 100.0f, 2);
        run_doubleQuery(double_filterL, FloatParameter, new Float(100.0f), 100.0, 2);
        run_doubleQuery(double_filterR, FloatParameter, new Float(69.96f), 69.96, 0);
        run_doubleQuery(double_filterL, BigIntegerParameter, new BigInteger("50000000"), 50000000.0f, 1);
        run_doubleQuery(double_filterR, BigIntegerParameter, new BigInteger("1000000000"), 1000000000.0f, 1);
        run_doubleQuery(double_filterL, BigDecimalParameter, new BigDecimal("350.5"), 350.5f, 1);
        run_doubleQuery(double_filterR, BigDecimalParameter, new BigDecimal("50000000.0"), 50000000.0f, 1);
        alltypes.setdouble(-25.5);
        run_doubleQuery(double_filterObj, AllTypesParameter, alltypes, -25.5, 1);
        run_doubleQuery(double_filterVal, null, null, 100.0, 2);
    
        run_BooleanQuery(Boolean_filterL, booleanParameter, Boolean.TRUE, Boolean.TRUE, 4);
        run_BooleanQuery(Boolean_filterL, booleanParameter, Boolean.FALSE, Boolean.FALSE, 6);
        run_BooleanQuery(Boolean_filterR, booleanParameter, Boolean.TRUE, Boolean.TRUE, 4);
        run_BooleanQuery(Boolean_filterR, booleanParameter, Boolean.FALSE, Boolean.FALSE, 6);
        run_BooleanQuery(Boolean_filterL, BooleanParameter, Boolean.TRUE, Boolean.TRUE, 4);
        run_BooleanQuery(Boolean_filterL, BooleanParameter, Boolean.FALSE, Boolean.FALSE, 6);
        run_BooleanQuery(Boolean_filterR, BooleanParameter, Boolean.TRUE, Boolean.TRUE, 4);
        run_BooleanQuery(Boolean_filterR, BooleanParameter, Boolean.FALSE, Boolean.FALSE, 6);
        run_BooleanQuery(Boolean_filterT, null, Boolean.TRUE, Boolean.TRUE, 4);
        run_BooleanQuery(Boolean_filterF, null, Boolean.FALSE, Boolean.FALSE, 6);
        alltypes.setBoolean(Boolean.TRUE);
        run_BooleanQuery(Boolean_filterObj, AllTypesParameter, alltypes, Boolean.TRUE, 4);
        alltypes.setBoolean(Boolean.FALSE);
        run_BooleanQuery(Boolean_filterObj, AllTypesParameter, alltypes, Boolean.FALSE, 6);

        run_ByteQuery(Byte_filterL, byteParameter, new Byte((byte)50), new Byte((byte)50), 2);
        run_ByteQuery(Byte_filterR, byteParameter, new Byte(Byte.MIN_VALUE), new Byte(Byte.MIN_VALUE), 1);
        run_ByteQuery(Byte_filterL, ByteParameter, new Byte((byte)20), new Byte((byte)20), 0);
        run_ByteQuery(Byte_filterR, ByteParameter, new Byte(Byte.MAX_VALUE), new Byte(Byte.MAX_VALUE), 1);    
        run_ByteQuery(Byte_filterL, shortParameter, new Short((short)50), new Byte((byte)50), 2);
        run_ByteQuery(Byte_filterR, shortParameter, new Short((short)50), new Byte((byte)50), 2);
        run_ByteQuery(Byte_filterL, ShortParameter, new Short((short)-100), new Byte((byte)-100), 1);
        run_ByteQuery(Byte_filterR, ShortParameter, new Short((short)-100), new Byte((byte)-100), 1);
        run_ByteQuery(Byte_filterL, charParameter, new Character((char)50), new Byte((byte)50), 2);
        run_ByteQuery(Byte_filterR, charParameter, new Character((char)50), new Byte((byte)50), 2);
        run_ByteQuery(Byte_filterL, CharacterParameter, new Character((char)50), new Byte((byte)50), 2);
        run_ByteQuery(Byte_filterR, CharacterParameter, new Character((char)75), new Byte((byte)75), 1);    
        run_ByteQuery(Byte_filterL, intParameter, new Integer(50), new Byte((byte)50), 2);
        run_ByteQuery(Byte_filterR, intParameter, new Integer(50), new Byte((byte)50), 2);
        run_ByteQuery(Byte_filterL, IntegerParameter, new Integer(50), new Byte((byte)50), 2);
        run_ByteQuery(Byte_filterR, IntegerParameter, new Integer(75), new Byte((byte)75), 1);
        run_ByteQuery(Byte_filterL, longParameter, new Long(50), new Byte((byte)50), 2);
        run_ByteQuery(Byte_filterR, longParameter, new Long(50), new Byte((byte)50), 2);
        run_ByteQuery(Byte_filterL, LongParameter, new Long(-100), new Byte((byte)-100), 1);
        run_ByteQuery(Byte_filterR, LongParameter, new Long(-100), new Byte((byte)-100), 1);
        run_ByteQuery(Byte_filterL, floatParameter, new Float(50), new Byte((byte)50), 2);
        run_ByteQuery(Byte_filterR, floatParameter, new Float(50), new Byte((byte)50), 2);
        run_ByteQuery(Byte_filterL, FloatParameter, new Float(-100), new Byte((byte)-100), 1);
        run_ByteQuery(Byte_filterR, FloatParameter, new Float(-100), new Byte((byte)-100), 1);
        run_ByteQuery(Byte_filterL, doubleParameter, new Double(50), new Byte((byte)50), 2);
        run_ByteQuery(Byte_filterR, doubleParameter, new Double(50), new Byte((byte)50), 2);
        run_ByteQuery(Byte_filterL, DoubleParameter, new Double(-100), new Byte((byte)-100), 1);
        run_ByteQuery(Byte_filterR, DoubleParameter, new Double(-100), new Byte((byte)-100), 1);
        run_ByteQuery(Byte_filterL, BigIntegerParameter, new BigInteger("50"), new Byte((byte)50), 2);
        run_ByteQuery(Byte_filterR, BigIntegerParameter, new BigInteger("-100"), new Byte((byte)-100), 1);
        run_ByteQuery(Byte_filterL, BigDecimalParameter, new BigDecimal("100.0"), new Byte((byte)100), 1);
        run_ByteQuery(Byte_filterR, BigDecimalParameter, new BigDecimal("10.0001"), new Byte((byte)10), 0);    
        Byte val = new Byte((byte)50);
        alltypes.setByte(val);
        run_ByteQuery(Byte_filterObj, AllTypesParameter, alltypes, val, 2);
        val = new Byte((byte)45);
        alltypes.setByte(val);
        run_ByteQuery(Byte_filterObj, AllTypesParameter, alltypes, val, 0);
        run_ByteQuery(Byte_filterVal, null, null, new Byte((byte)100), 1);
    
        run_ShortQuery(Short_filterL, shortParameter, new Short((short)100), new Short((short)100), 2);
        run_ShortQuery(Short_filterR, shortParameter, new Short((short)100), new Short((short)100), 2);
        run_ShortQuery(Short_filterL, ShortParameter, new Short(Short.MIN_VALUE), new Short(Short.MIN_VALUE), 1);
        run_ShortQuery(Short_filterR, ShortParameter, new Short((short)253), new Short((short)253), 0);
        run_ShortQuery(Short_filterR, shortParameter, new Short((short)1000), new Short((short)1000), 1);
        run_ShortQuery(Short_filterL, byteParameter, new Byte((byte)75), new Short((short)75), 0);
        run_ShortQuery(Short_filterR, byteParameter, new Byte((byte)75), new Short((short)75), 0);
        run_ShortQuery(Short_filterL, ByteParameter, new Byte((byte)100), new Short((short)100), 2);
        run_ShortQuery(Short_filterR, ByteParameter, new Byte((byte)100), new Short((short)100), 2);
        run_ShortQuery(Short_filterL, charParameter, new Character((char)75), new Short((short)75), 0);
        run_ShortQuery(Short_filterR, charParameter, new Character((char)75), new Short((short)75), 0);
        run_ShortQuery(Short_filterL, CharacterParameter, new Character((char)100), new Short((short)100), 2);
        run_ShortQuery(Short_filterR, CharacterParameter, new Character((char)100), new Short((short)100), 2);
        run_ShortQuery(Short_filterL, intParameter, new Integer(-10000), new Short((short)-10000), 1);
        run_ShortQuery(Short_filterR, intParameter, new Integer(-10000), new Short((short)-10000), 1);
        run_ShortQuery(Short_filterL, IntegerParameter, new Integer(10000), new Short((short)10000), 1);
        run_ShortQuery(Short_filterR, IntegerParameter, new Integer(10000), new Short((short)10000), 1);
        run_ShortQuery(Short_filterL, longParameter, new Long(10000), new Short((short) 10000), 1);
        run_ShortQuery(Short_filterR, longParameter, new Long(10000), new Short((short) 10000), 1);
        run_ShortQuery(Short_filterL, LongParameter, new Long(100), new Short((short)100), 2);
        run_ShortQuery(Short_filterR, LongParameter, new Long(100), new Short((short)100), 2);
        run_ShortQuery(Short_filterL, floatParameter, new Float(23000), new Short((short)23000), 0);
        run_ShortQuery(Short_filterR, floatParameter, new Float(23000), new Short((short)23000), 0);
        run_ShortQuery(Short_filterL, FloatParameter, new Float(100), new Short((short)100), 2);
        run_ShortQuery(Short_filterR, FloatParameter, new Float(100), new Short((short)100), 2);
        run_ShortQuery(Short_filterL, doubleParameter, new Double(-10000), new Short((short)-10000), 1);
        run_ShortQuery(Short_filterR, doubleParameter, new Double(-10000), new Short((short)-10000), 1);
        run_ShortQuery(Short_filterL, DoubleParameter, new Double(23), new Short((short)23), 0);
        run_ShortQuery(Short_filterR, DoubleParameter, new Double(23), new Short((short)23), 0);
        run_ShortQuery(Short_filterL, BigIntegerParameter, new BigInteger("999"), new Short((short)999), 0);
        run_ShortQuery(Short_filterR, BigIntegerParameter, new BigInteger("-1000"), new Short((short)-1000), 1);
        run_ShortQuery(Short_filterL, BigDecimalParameter, new BigDecimal("100.0"), new Short((short)100), 2);
        run_ShortQuery(Short_filterR, BigDecimalParameter, new BigDecimal("101.0"), new Short((short)100), 0);    
        Short sval = new Short((short)100);
        alltypes.setShort(sval);
        run_ShortQuery(Short_filterObj, AllTypesParameter, alltypes, sval, 2);
        sval = new Short((short)23);
        alltypes.setShort(sval);
        run_ShortQuery(Short_filterObj, AllTypesParameter, alltypes, sval, 0);
        run_ShortQuery(Short_filterVal, null, null, new Short((short)-1000), 1);
    
        run_CharacterQuery(Character_filterL, charParameter, new Character(Character.MIN_VALUE), new Character(Character.MIN_VALUE), 1);
        run_CharacterQuery(Character_filterR, charParameter, new Character(Character.MAX_VALUE), new Character(Character.MAX_VALUE), 1);
        run_CharacterQuery(Character_filterL, charParameter, new Character('C'), new Character('C'), 0);
        run_CharacterQuery(Character_filterR, charParameter, new Character('z'), new Character('z'), 2);
        run_CharacterQuery(Character_filterL, CharacterParameter, new Character(' '), new Character(' '), 1);
        run_CharacterQuery(Character_filterR, CharacterParameter, new Character('f'), new Character('f'), 0);
        run_CharacterQuery(Character_filterL, byteParameter, new Byte((byte)Character.MIN_VALUE), new Character((char)Character.MIN_VALUE), 1);
        run_CharacterQuery(Character_filterR, ByteParameter, new Byte((byte)'a'), new Character('a'), 0);
        run_CharacterQuery(Character_filterL, shortParameter, new Short((short)'M'), new Character('M'), 2);
        run_CharacterQuery(Character_filterR, shortParameter, new Short((short)'F'), new Character('F'), 1);
        run_CharacterQuery(Character_filterL, ShortParameter, new Short((short)'A'), new Character('A'), 1);
        run_CharacterQuery(Character_filterR, ShortParameter, new Short((short)'A'), new Character('A'), 1);
        run_CharacterQuery(Character_filterL, intParameter, new Integer('z'), new Character('z'), 2);
        run_CharacterQuery(Character_filterR, intParameter, new Integer('z'), new Character('z'), 2);
        run_CharacterQuery(Character_filterL, IntegerParameter, new Integer('B'), new Character('B'), 1);
        run_CharacterQuery(Character_filterR, IntegerParameter, new Integer('B'), new Character('B'), 1);
        run_CharacterQuery(Character_filterL, longParameter, new Long('z'), new Character('z'), 2);
        run_CharacterQuery(Character_filterR, longParameter, new Long('z'), new Character('z'), 2);
        run_CharacterQuery(Character_filterL, LongParameter, new Long('B'), new Character('B'), 1);
        run_CharacterQuery(Character_filterR, LongParameter, new Long('B'), new Character('B'), 1);
        run_CharacterQuery(Character_filterL, floatParameter, new Float(123.222), new Character('x'), 0);
        run_CharacterQuery(Character_filterR, floatParameter, new Float(123.222), new Character('x'), 0);
        run_CharacterQuery(Character_filterL, FloatParameter, new Float('z'), new Character('z'), 2);
        run_CharacterQuery(Character_filterR, FloatParameter, new Float('z'), new Character('z'), 2);
        run_CharacterQuery(Character_filterL, doubleParameter, new Double('B'), new Character('B'), 1);
        run_CharacterQuery(Character_filterR, doubleParameter, new Double('B'), new Character('B'), 1);
        run_CharacterQuery(Character_filterL, DoubleParameter, new Double('A'), new Character('A'), 1);
        run_CharacterQuery(Character_filterR, DoubleParameter, new Double('A'), new Character('A'), 1);
        run_CharacterQuery(Character_filterL, BigIntegerParameter, new BigInteger("65"), new Character('A'), 1);   // 'A' == 65
        run_CharacterQuery(Character_filterR, BigIntegerParameter, new BigInteger("122"), new Character('z'), 2);  // 'z' == 122
        run_CharacterQuery(Character_filterL, BigDecimalParameter, new BigDecimal("65.0"), new Character('A'), 1);
        run_CharacterQuery(Character_filterR, BigDecimalParameter, new BigDecimal("77.0"), new Character('M'), 2); // 'M' == 77
        alltypes.setCharacter(new Character('A'));
        run_CharacterQuery(Character_filterObj, AllTypesParameter, alltypes, new Character('A'), 1);
        alltypes.setCharacter(new Character('b'));
        run_CharacterQuery(Character_filterObj, AllTypesParameter, alltypes, new Character('b'), 0);
        run_CharacterQuery(Character_filterVal, null, null, new Character('z'), 2);
    
        run_IntegerQuery(Integer_filterL, intParameter, new Integer(AllTypes.veryLargeNegativeInt), new Integer(AllTypes.veryLargeNegativeInt), 1);
        run_IntegerQuery(Integer_filterR, intParameter, new Integer(AllTypes.veryLargePositiveInt), new Integer(AllTypes.veryLargePositiveInt), 1);
        run_IntegerQuery(Integer_filterR, intParameter, new Integer(23), new Integer(23), 0);
        run_IntegerQuery(Integer_filterL, IntegerParameter, new Integer(1000000), new Integer(1000000), 1);
        run_IntegerQuery(Integer_filterR, IntegerParameter, new Integer(1000), new Integer(1000), 1);
        run_IntegerQuery(Integer_filterL, byteParameter, new Byte((byte)100), new Integer(100), 2);
        run_IntegerQuery(Integer_filterR, byteParameter, new Byte((byte)0), new Integer(0), 1);
        run_IntegerQuery(Integer_filterL, ByteParameter, new Byte((byte)100), new Integer(100), 2);
        run_IntegerQuery(Integer_filterR, ByteParameter, new Byte((byte)0), new Integer(0), 1);
        run_IntegerQuery(Integer_filterL, shortParameter, new Short((short)10000), new Integer(10000), 1);
        run_IntegerQuery(Integer_filterR, shortParameter, new Short((short)-1000), new Integer(-1000), 1);
        run_IntegerQuery(Integer_filterL, ShortParameter, new Short((short)-1000), new Integer(-1000), 1);
        run_IntegerQuery(Integer_filterL, charParameter, new Character((char)10000), new Integer(10000), 1);
        run_IntegerQuery(Integer_filterR, charParameter, new Character((char)10000), new Integer(10000), 1);
        run_IntegerQuery(Integer_filterL, CharacterParameter, new Character((char)100), new Integer(100), 2);
        run_IntegerQuery(Integer_filterR, CharacterParameter, new Character((char)10000), new Integer(10000), 1);
        run_IntegerQuery(Integer_filterL, longParameter, new Long(AllTypes.veryLargePositiveInt), new Integer(AllTypes.veryLargePositiveInt), 1);
        run_IntegerQuery(Integer_filterR, longParameter, new Long(AllTypes.veryLargeNegativeInt), new Integer(AllTypes.veryLargeNegativeInt), 1);
        run_IntegerQuery(Integer_filterL, LongParameter, new Long(10000), new Integer(10000), 1);
        run_IntegerQuery(Integer_filterR, LongParameter, new Long(43), new Integer(43), 0);
        run_IntegerQuery(Integer_filterL, floatParameter, new Float(AllTypes.veryLargePositiveInt), new Integer(AllTypes.veryLargePositiveInt), 1);
        run_IntegerQuery(Integer_filterR, floatParameter, new Float(AllTypes.veryLargeNegativeInt), new Integer(AllTypes.veryLargeNegativeInt), 1);
        run_IntegerQuery(Integer_filterL, FloatParameter, new Float(10000), new Integer(10000), 1);
        run_IntegerQuery(Integer_filterR, FloatParameter, new Float(43), new Integer(43), 0);
        run_IntegerQuery(Integer_filterL, doubleParameter, new Double(AllTypes.veryLargePositiveInt), new Integer(AllTypes.veryLargePositiveInt), 1);
        run_IntegerQuery(Integer_filterR, doubleParameter, new Double(AllTypes.veryLargeNegativeInt), new Integer(AllTypes.veryLargeNegativeInt), 1);
        run_IntegerQuery(Integer_filterL, DoubleParameter, new Double(10000), new Integer(10000), 1);
        run_IntegerQuery(Integer_filterR, DoubleParameter, new Double(43), new Integer(43), 0);
        run_IntegerQuery(Integer_filterL, BigIntegerParameter, new BigInteger("1000000"), new Integer(1000000), 1);
        run_IntegerQuery(Integer_filterR, BigIntegerParameter, new BigInteger("-1000000"), new Integer(-1000000), 1);
        run_IntegerQuery(Integer_filterL, BigDecimalParameter, new BigDecimal("1000000.0"), new Integer(1000000), 1);
        run_IntegerQuery(Integer_filterR, BigDecimalParameter, new BigDecimal("-1000000.01"), new Integer(-1000000), 0);
        alltypes.setInteger(new Integer(100));
        run_IntegerQuery(Integer_filterObj, AllTypesParameter, alltypes, new Integer(100), 2);
        run_IntegerQuery(Integer_filterVal, null, null, new Integer(100), 2);
    
        run_LongQuery(Long_filterL, longParameter, new Long(Long.MIN_VALUE), new Long(Long.MIN_VALUE), 1);
        run_LongQuery(Long_filterR, longParameter, new Long(Long.MAX_VALUE), new Long(Long.MAX_VALUE), 1);
        run_LongQuery(Long_filterL, LongParameter, new Long(100), new Long(100), 2);
        run_LongQuery(Long_filterR, LongParameter, new Long(23), new Long(23), 0);
        run_LongQuery(Long_filterL, byteParameter, new Byte((byte)100), new Long(100), 2);
        run_LongQuery(Long_filterR, byteParameter, new Byte((byte)0), new Long(0), 1);
        run_LongQuery(Long_filterL, ByteParameter, new Byte((byte)100), new Long(100), 2);
        run_LongQuery(Long_filterR, ByteParameter, new Byte((byte)0), new Long(0), 1);
        run_LongQuery(Long_filterL, shortParameter, new Short((short)-1000 ), new Long(-1000), 2);
        run_LongQuery(Long_filterR, shortParameter, new Short((short)1000), new Long(1000), 1);
        run_LongQuery(Long_filterL, ShortParameter, new Short((short)100), new Long(100), 2);
        run_LongQuery(Long_filterR, ShortParameter, new Short((short)32), new Long(32), 0);
        run_LongQuery(Long_filterL, charParameter, new Character((char)0), new Long(0), 1);
        run_LongQuery(Long_filterR, charParameter, new Character((char)100), new Long(100), 2);
        run_LongQuery(Long_filterL, CharacterParameter, new Character((char)23), new Long(23), 0);
        run_LongQuery(Long_filterR, CharacterParameter, new Character((char)0), new Long(0), 1);
        run_LongQuery(Long_filterL, intParameter, new Integer(100), new Long(100), 2);
        run_LongQuery(Long_filterR, intParameter, new Integer(0), new Long(0), 1);
        run_LongQuery(Long_filterL, IntegerParameter, new Integer(23), new Long(23), 0);
        run_LongQuery(Long_filterR, IntegerParameter, new Integer(1000000), new Long(1000000), 1);
        run_LongQuery(Long_filterL, longParameter, new Long(100), new Long(100), 2);
        run_LongQuery(Long_filterR, longParameter, new Long(0), new Long(0), 1);
        run_LongQuery(Long_filterL, LongParameter, new Long(23), new Long(23), 0);
        run_LongQuery(Long_filterR, LongParameter, new Long(1000000), new Long(1000000), 1);
        run_LongQuery(Long_filterL, floatParameter, new Float(-1000000.0), new Long(-1000000), 1);
//    run_LongQuery(Long_filterR, floatParameter, new Float((float)Long.MAX_VALUE), new Long(Long.MAX_VALUE), 1);
        run_LongQuery(Long_filterL, FloatParameter, new Float(100), new Long(100), 2);
        run_LongQuery(Long_filterR, FloatParameter, new Float(32), new Long(32), 0);
        run_LongQuery(Long_filterL, doubleParameter, new Double(-1000000.0), new Long(-1000000), 1);
//    run_LongQuery(Long_filterR, doubleParameter, new Double((double)Long.MAX_VALUE), new Long(Long.MAX_VALUE), 1);
        run_LongQuery(Long_filterL, DoubleParameter, new Double(100), new Long(100), 2);
        run_LongQuery(Long_filterR, DoubleParameter, new Double(32), new Long(32), 0);
        run_LongQuery(Long_filterL, BigIntegerParameter, new BigInteger("1000000"), new Long(1000000), 1);
        run_LongQuery(Long_filterR, BigIntegerParameter, new BigInteger("-1000000"), new Long(-1000000), 1);
        run_LongQuery(Long_filterL, BigDecimalParameter, new BigDecimal("1000000.0"), new Long(1000000), 1);
        run_LongQuery(Long_filterR, BigDecimalParameter, new BigDecimal("-1000000.0001"), new Long(-1000000), 0);
        alltypes.setLong(new Long(100));
        run_LongQuery(Long_filterObj, AllTypesParameter, alltypes, new Long(100), 2);
        run_LongQuery(Long_filterVal, null, null, new Long(-1000), 2);
    
        run_FloatQuery(Float_filterL, floatParameter, new Float(350.5f), new Float(350.5f), 1);
        run_FloatQuery(Float_filterR, floatParameter, new Float(350.5f), new Float(350.5f), 1);
        run_FloatQuery(Float_filterL, FloatParameter, new Float(0.0), new Float(0.0f), 1);
        run_FloatQuery(Float_filterR, FloatParameter, new Float(4.0), new Float(4.0f), 0);
        run_FloatQuery(Float_filterL, byteParameter, new Byte((byte)0), new Float(0.0f), 1);
        run_FloatQuery(Float_filterR, byteParameter, new Byte((byte)23), new Float(23.0f), 0);
        run_FloatQuery(Float_filterL, ByteParameter, new Byte((byte)34), new Float(34.0f), 0);
        run_FloatQuery(Float_filterR, ByteParameter, new Byte((byte)100), new Float(100.0f), 2);
        run_FloatQuery(Float_filterL, shortParameter, new Short((short)0), new Float(0.0f), 1);
        run_FloatQuery(Float_filterR, shortParameter, new Short((short)23), new Float(23.0f), 0);
        run_FloatQuery(Float_filterL, ShortParameter, new Short((short)34), new Float(34.0f), 0);
        run_FloatQuery(Float_filterR, ShortParameter, new Short((short)100), new Float(100.0f), 2);
        run_FloatQuery(Float_filterL, charParameter, new Character((char)0), new Float(0.0f), 1);
        run_FloatQuery(Float_filterR, charParameter, new Character((char)23), new Float(23.0f), 0);
        run_FloatQuery(Float_filterL, CharacterParameter, new Character((char)34), new Float(34.0f), 0);
        run_FloatQuery(Float_filterR, CharacterParameter, new Character((char)100), new Float(100.0f), 2);
        run_FloatQuery(Float_filterL, intParameter, new Integer(50000000), new Float(50000000.0f), 1);
        run_FloatQuery(Float_filterR, intParameter, new Integer(23), new Float(23.0f), 0);
        run_FloatQuery(Float_filterL, IntegerParameter, new Integer(34), new Float(34.0f), 0);
        run_FloatQuery(Float_filterR, IntegerParameter, new Integer(100), new Float(100.0f), 2);
        run_FloatQuery(Float_filterL, longParameter, new Long(50000000), new Float(50000000.0f), 1);
        run_FloatQuery(Float_filterR, longParameter, new Long(23), new Float(23.0f), 0);
        run_FloatQuery(Float_filterL, LongParameter, new Long(34), new Float(34.0f), 0);
        run_FloatQuery(Float_filterR, LongParameter, new Long(100), new Float(100.0f), 2);
        run_FloatQuery(Float_filterL, doubleParameter, new Double(50000000.0f), new Float(50000000.0f), 1);
        run_FloatQuery(Float_filterR, doubleParameter, new Double(100.0f), new Float(100.0f), 2);
        run_FloatQuery(Float_filterL, DoubleParameter, new Double(0.0f), new Float(0.0f), 1);
        run_FloatQuery(Float_filterR, DoubleParameter, new Double(100.0f), new Float(100.0f), 2);
        run_FloatQuery(Float_filterL, BigIntegerParameter, new BigInteger("50000000"), new Float(50000000.0f), 1);
        run_FloatQuery(Float_filterR, BigIntegerParameter, new BigInteger("1000000000"), new Float(1000000000.0f), 1);
        run_FloatQuery(Float_filterL, BigDecimalParameter, new BigDecimal("350.5"), new Float(350.5f), 1);
        run_FloatQuery(Float_filterR, BigDecimalParameter, new BigDecimal("50000000.0"), new Float(50000000.0f), 1);
        alltypes.setFloat(new Float(23.23f));
        run_FloatQuery(Float_filterObj, AllTypesParameter, alltypes, new Float(23.23f), 0);
        run_FloatQuery(Float_filterVal, null, null, new Float(100.0f), 2);
    
        run_DoubleQuery(Double_filterL, doubleParameter, new Double(350.5), new Double(350.5), 1);
        run_DoubleQuery(Double_filterR, doubleParameter, new Double(350.5), new Double(350.5), 1);
        run_DoubleQuery(Double_filterL, DoubleParameter, new Double(0.0), new Double(0.0), 1);
        run_DoubleQuery(Double_filterR, DoubleParameter, new Double(23.34), new Double(23.34), 0);
        run_DoubleQuery(Double_filterL, byteParameter, new Byte((byte)100), new Double(100.0), 2);
        run_DoubleQuery(Double_filterR, byteParameter, new Byte((byte)0), new Double(0.0), 1);
        run_DoubleQuery(Double_filterL, ByteParameter, new Byte((byte)23), new Double(23.0), 0);
        run_DoubleQuery(Double_filterR, ByteParameter, new Byte((byte)100), new Double(100.0), 2);
        run_DoubleQuery(Double_filterL, shortParameter, new Short((short)100), new Double(100.0), 2);
        run_DoubleQuery(Double_filterR, shortParameter, new Short((short)0), new Double(0.0), 1);
        run_DoubleQuery(Double_filterL, ShortParameter, new Short((short)23), new Double(23.0), 0);
        run_DoubleQuery(Double_filterR, ShortParameter, new Short((short)100), new Double(100.0), 2);
        run_DoubleQuery(Double_filterL, charParameter, new Character((char)100), new Double(100.0), 2);
        run_DoubleQuery(Double_filterR, charParameter, new Character((char)0), new Double(0.0), 1);
        run_DoubleQuery(Double_filterL, CharacterParameter, new Character((char)23), new Double(23.0), 0);
        run_DoubleQuery(Double_filterR, CharacterParameter, new Character((char)100), new Double(100.0), 2);
        run_DoubleQuery(Double_filterL, intParameter, new Integer(100), new Double(100.0), 2);
        run_DoubleQuery(Double_filterR, intParameter, new Integer(0), new Double(0.0), 1);
        run_DoubleQuery(Double_filterL, IntegerParameter, new Integer(23), new Double(23.0), 0);
        run_DoubleQuery(Double_filterR, IntegerParameter, new Integer(100), new Double(100.0), 2);
        run_DoubleQuery(Double_filterL, longParameter, new Long(100), new Double(100.0), 2);
        run_DoubleQuery(Double_filterR, longParameter, new Long(0), new Double(0.0), 1);
        run_DoubleQuery(Double_filterL, LongParameter, new Long(23), new Double(23.0), 0);
        run_DoubleQuery(Double_filterR, LongParameter, new Long(100), new Double(100.0), 2);
        run_DoubleQuery(Double_filterL, floatParameter, new Float(0.0f), new Double(0.0f), 1);
        run_DoubleQuery(Double_filterR, floatParameter, new Float(100.0f), new Double(100.0f), 2);
        run_DoubleQuery(Double_filterL, FloatParameter, new Float(100.0f), new Double(100.0f), 2);
        run_DoubleQuery(Double_filterR, FloatParameter, new Float(69.96f), new Double(69.96), 0);
        run_DoubleQuery(Double_filterL, BigIntegerParameter, new BigInteger("50000000"), new Double(50000000.0f), 1);
        run_DoubleQuery(Double_filterR, BigIntegerParameter, new BigInteger("1000000000"), new Double(1000000000.0f), 1);
        run_DoubleQuery(Double_filterL, BigDecimalParameter, new BigDecimal("350.5"), new Double(350.5f), 1);
        run_DoubleQuery(Double_filterR, BigDecimalParameter, new BigDecimal("50000000.0"), new Double(50000000.0f), 1);
        alltypes.setDouble(new Double(-25.5));
        run_DoubleQuery(Double_filterObj, AllTypesParameter, alltypes, new Double(-25.5), 1);
        run_DoubleQuery(Double_filterVal, null, null, new Double(-25.5), 1);

        run_StringQuery(String_filterL, StringParameter, new String("JDO"), new String("JDO"), 1);
        run_StringQuery(String_filterR, StringParameter, new String("JDBC"), new String("JDBC"), 0);
        alltypes.setString(new String("abcde"));
        run_StringQuery(String_filterObj, AllTypesParameter, alltypes, new String("abcde"), 1);
        run_StringQuery(String_filterVal1, null, null, new String("Java"), 2);
        run_StringQuery(String_filterVal2, null, null, new String(""), 1);

        run_LocaleQuery(Locale_filterL, LocaleParameter, Locale.CANADA_FRENCH, Locale.CANADA_FRENCH, 0);
        run_LocaleQuery(Locale_filterR, LocaleParameter, Locale.US, Locale.US, 1);
        alltypes.setLocale(Locale.UK);
        run_LocaleQuery(Locale_filterObj, AllTypesParameter, alltypes, Locale.UK, 1);
    
        BigDecimal bd = new BigDecimal("100.0");
        run_BigDecimalQuery(BigDecimal_filterL, BigDecimalParameter, bd, bd, 2);
        bd = new BigDecimal("-234234.23333");
        run_BigDecimalQuery(BigDecimal_filterR, BigDecimalParameter, bd, bd, 1);
        bd = new BigDecimal("989899.33304953");
        run_BigDecimalQuery(BigDecimal_filterL, BigDecimalParameter, bd, bd, 0);
        bd = new BigDecimal("-1123123.22");
        run_BigDecimalQuery(BigDecimal_filterR, BigDecimalParameter, bd, bd, 1);
        alltypes.setBigDecimal(bd);
        run_BigDecimalQuery(BigDecimal_filterObj, AllTypesParameter, alltypes, bd, 1);

        BigInteger bi = new BigInteger("987034534985043985");
        run_BigIntegerQuery(BigInteger_filterL, BigIntegerParameter, bi, bi, 1);
        bi = new BigInteger("-999999999999999999");
        run_BigIntegerQuery(BigInteger_filterR, BigIntegerParameter, bi, bi, 1);
        bi = new BigInteger("-99999999999999999");
        run_BigIntegerQuery(BigInteger_filterR, BigIntegerParameter, bi, bi, 0);
        bi = new BigInteger("1333330");
        alltypes.setBigInteger(bi);
        run_BigIntegerQuery(BigInteger_filterObj, AllTypesParameter, alltypes, bi, 1);
    
        GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone("GMT"), Locale.UK);
        gc.clear();
        gc.set(1999, Calendar.DECEMBER, 31, 9, 0, 0);
        Date d = gc.getTime();
        run_DateQuery(Date_filterL, DateParameter, d, d, 1);
        gc.set(1992, Calendar.NOVEMBER, 22, 9, 0, 0);
        d = gc.getTime();
        run_DateQuery(Date_filterR, DateParameter, d, d, 1);
        gc.set(1959, Calendar.OCTOBER, 9, 9, 0, 0);
        d = gc.getTime();
        run_DateQuery(Date_filterR, DateParameter, d, d, 0);
        gc.set(1995, Calendar.JUNE, 14, 9, 0, 0);
        d = gc.getTime();
        alltypes.setDate(d);
        run_DateQuery(Date_filterObj, AllTypesParameter, alltypes, d, 1);
    }

    private void run_booleanQuery(String filter, String parameter, Object parameterValue, boolean value, int expected_count)
    {
        tx.begin();
        runQuery(pm, filter, parameter, parameterValue, ASSERTION_FAILED);
        if( query_result == null )
            return;
        Iterator iter = query_result.iterator();
        int cnt = 0;
        while(iter.hasNext()){
            AllTypes obj = (AllTypes) iter.next();
            boolean val = obj.getboolean();
            if (val != value) {
                fail(ASSERTION_FAILED, "JDOQL Equality test returns object with incorrect value, retrieved value: " + val + ", expected value: " + value, filter, parameter);
            }
            cnt++;
        }
        if( cnt != expected_count ){
            fail(ASSERTION_FAILED, "JDOQL Equality test returns wrong number of instances, expected " + expected_count + ", got " + cnt, filter, parameter);
        }
        query.close(query_result);
        tx.rollback();
    }

    private void run_byteQuery(String filter, String parameter, Object parameterValue, byte value, int expected_count)
    {
        tx.begin();
        runQuery(pm, filter, parameter, parameterValue, ASSERTION_FAILED);
        if( query_result == null )
            return;
        Iterator iter = query_result.iterator();
        int cnt = 0;
        while( iter.hasNext() ){
            AllTypes obj = (AllTypes) iter.next();
            byte val = obj.getbyte();
            if( val != value ){
                fail(ASSERTION_FAILED, "JDOQL Equality test returns incorrect value, retrieved value: " + val + ", with parameter value: " + value, filter, parameter);
            }
            cnt++;
        }
        if( cnt != expected_count ){
            fail(ASSERTION_FAILED, "JDOQL Equality test returns wrong number of instances, expected " + expected_count + ", got " + cnt, filter, parameter);
        }
        query.close(query_result);
        tx.rollback();
    }

    private void run_shortQuery(String filter, String parameter, Object parameterValue, short value, int expected_count)
    {
        tx.begin();
        runQuery(pm, filter, parameter, parameterValue, ASSERTION_FAILED);
        if( query_result == null )
            return;
        Iterator iter = query_result.iterator();
        int cnt = 0;
        while( iter.hasNext() ){
            AllTypes obj = (AllTypes) iter.next();
            short val = obj.getshort();
            if( val != value ){
                fail(ASSERTION_FAILED, "JDOQL Equality test returns incorrect value, retrieved value: " + val + ", with parameter value: " + value, filter, parameter);
            }
            cnt++;
        }
        if( cnt != expected_count ){
            fail(ASSERTION_FAILED, "JDOQL Equality test returns wrong number of instances, expected " + expected_count + ", got " + cnt, filter, parameter);
        }
        query.close(query_result);
        tx.rollback();
    }

    private void run_charQuery(String filter, String parameter, Object parameterValue, char value, int expected_count)
    {
        tx.begin();
        runQuery(pm, filter, parameter, parameterValue, ASSERTION_FAILED);
        if( query_result == null )
            return;
        Iterator iter = query_result.iterator();
        int cnt = 0;
        while( iter.hasNext() ){
            AllTypes obj = (AllTypes) iter.next();
            char val = obj.getchar();
            if( val != value ){
                fail(ASSERTION_FAILED, "JDOQL Equality test returns incorrect value, retrieved value: " + val + ", with parameter value: " + value, filter, parameter);
            }
            cnt++;
        }
        if( cnt != expected_count ){
            fail(ASSERTION_FAILED, "JDOQL Equality test returns wrong number of instances, expected " + expected_count + ", got " + cnt, filter, parameter);
        }
        query.close(query_result);
        tx.rollback();
    }

    private void run_intQuery(String filter, String parameter, Object parameterValue, int value, int expected_count)
    {
        tx.begin();
        runQuery(pm, filter, parameter, parameterValue, ASSERTION_FAILED);
        if( query_result == null )
            return;
        Iterator iter = query_result.iterator();
        int cnt = 0;
        while( iter.hasNext() ){
            AllTypes obj = (AllTypes) iter.next();
            int val = obj.getint();
            if( val != value ){
                fail(ASSERTION_FAILED, "JDOQL Equality test returns incorrect value, retrieved value: " + val + ", with parameter value: " + value, filter, parameter);
            }
            cnt++;
        }
        if( cnt != expected_count ){
            fail(ASSERTION_FAILED, "JDOQL Equality test returns wrong number of instances, expected " + expected_count + ", got " + cnt, filter, parameter);
        }
        query.close(query_result);
        tx.rollback();
    }

    private void run_longQuery(String filter, String parameter, Object parameterValue, long value, int expected_count)
    {
        tx.begin();
        runQuery(pm, filter, parameter, parameterValue, ASSERTION_FAILED);
        if( query_result == null )
            return;
        Iterator iter = query_result.iterator();
        int cnt = 0;
        while( iter.hasNext() ){
            AllTypes obj = (AllTypes) iter.next();
            long val = obj.getlong();
            if( val != value ){
                fail(ASSERTION_FAILED, "JDOQL Equality test returns incorrect value, retrieved value: " + val + ", with parameter value: " + value, filter, parameter);
            }
            cnt++;
        }
        if( cnt != expected_count ){
            fail(ASSERTION_FAILED, "JDOQL Equality test returns wrong number of instances, expected " + expected_count + ", got " + cnt, filter, parameter);
        }
        query.close(query_result);
        tx.rollback();
    }

    private void run_floatQuery(String filter, String parameter, Object parameterValue, float value, int expected_count)
    {
        tx.begin();
        runQuery(pm, filter, parameter, parameterValue, ASSERTION_FAILED);
        if( query_result == null )
            return;
        Iterator iter = query_result.iterator();
        int cnt = 0;
        while( iter.hasNext() ){
            AllTypes obj = (AllTypes) iter.next();
            float val = obj.getfloat();
            if( val != value ){
                fail(ASSERTION_FAILED, "JDOQL Equality test returns incorrect value, retrieved value: " + val + ", with parameter value: " + value, filter, parameter);
            }
            cnt++;
        }
        if( cnt != expected_count ){
            fail(ASSERTION_FAILED, "JDOQL Equality test returns wrong number of instances, expected " + expected_count + ", got " + cnt, filter, parameter);
        }
        query.close(query_result);
        tx.rollback();
    }

    private void run_doubleQuery(String filter, String parameter, Object parameterValue, double value, int expected_count)
    {
        tx.begin();
        runQuery(pm, filter, parameter, parameterValue, ASSERTION_FAILED);
        if( query_result == null )
            return;
        Iterator iter = query_result.iterator();
        int cnt = 0;
        while( iter.hasNext() ){
            AllTypes obj = (AllTypes) iter.next();
            double val = obj.getdouble();
            if( val != value ){
                fail(ASSERTION_FAILED, "JDOQL Equality test returns incorrect value, retrieved value: " + val + ", with parameter value: " + value, filter, parameter);
            }
            cnt++;
        }
        if( cnt != expected_count ){
            fail(ASSERTION_FAILED, "JDOQL Equality test returns wrong number of instances, expected " + expected_count + ", got " + cnt, filter, parameter);
        }
        query.close(query_result);
        tx.rollback();
    }

    private void run_BooleanQuery(String filter, String parameter, Object parameterValue, Boolean value, int expected_count)
    {
        tx.begin();
        runQuery(pm, filter, parameter, parameterValue, ASSERTION_FAILED);
        if( query_result == null )
            return;
        Iterator iter = query_result.iterator();
        int cnt = 0;
        while(iter.hasNext()){
            AllTypes obj = (AllTypes) iter.next();
            Boolean val = obj.getBoolean();
            if( !val.equals(value) ){
                fail(ASSERTION_FAILED, "JDOQL Equality test returns object with incorrect value", filter, parameter);
            }
            cnt++;
        }
        if( cnt != expected_count ){
            fail(ASSERTION_FAILED, "JDOQL Equality test returns wrong number of instances, expected " + expected_count + ", got " + cnt, filter, parameter);
        }
        query.close(query_result);
        tx.rollback();
    }

    private void run_ByteQuery(String filter, String parameter, Object parameterValue, Byte value, int expected_count)
    {
        tx.begin();
        runQuery(pm, filter, parameter, parameterValue, ASSERTION_FAILED);
        if( query_result == null )
            return;
        Iterator iter = query_result.iterator();
        int cnt = 0;
        while( iter.hasNext() ){
            AllTypes obj = (AllTypes) iter.next();
            Byte val = obj.getByte();
            if( !val.equals(value) ){
                fail(ASSERTION_FAILED, "JDOQL Equality test returns incorrect value, retrieved value: " + val + ", with parameter value: " + value, filter, parameter);
            }
            cnt++;
        }
        if( cnt != expected_count ){
            fail(ASSERTION_FAILED, "JDOQL Equality test returns wrong number of instances, expected " + expected_count + ", got " + cnt, filter, parameter);
        }
        query.close(query_result);
        tx.rollback();
    }

    private void run_ShortQuery(String filter, String parameter, Object parameterValue, Short value, int expected_count)
    {
        tx.begin();
        runQuery(pm, filter, parameter, parameterValue, ASSERTION_FAILED);
        if( query_result == null )
            return;
        Iterator iter = query_result.iterator();
        int cnt = 0;
        while( iter.hasNext() ){
            AllTypes obj = (AllTypes) iter.next();
            Short val = obj.getShort();
            if( !val.equals(value) ){
                fail(ASSERTION_FAILED, "JDOQL Equality test returns incorrect value, retrieved value: " + val + ", with parameter value: " + value, filter, parameter);
            }
            cnt++;
        }
        if( cnt != expected_count ){
            fail(ASSERTION_FAILED, "JDOQL Equality test returns wrong number of instances, expected " + expected_count + ", got " + cnt, filter, parameter);
        }
        query.close(query_result);
        tx.rollback();
    }

    private void run_CharacterQuery(String filter, String parameter, Object parameterValue, Character value, int expected_count)
    {
        tx.begin();
        runQuery(pm, filter, parameter, parameterValue, ASSERTION_FAILED);
        if( query_result == null )
            return;
        Iterator iter = query_result.iterator();
        int cnt = 0;
        while( iter.hasNext() ){
            AllTypes obj = (AllTypes) iter.next();
            Character val = obj.getCharacter();
            if( !val.equals(value) ){
                fail(ASSERTION_FAILED, "JDOQL Equality test returns incorrect value, retrieved value: " + val + ", with parameter value: " + value, filter, parameter);
            }
            cnt++;
        }
        if( cnt != expected_count ){
            fail(ASSERTION_FAILED, "JDOQL Equality test returns wrong number of instances, expected " + expected_count + ", got " + cnt, filter, parameter);
        }
        query.close(query_result);
        tx.rollback();
    }

    private void run_IntegerQuery(String filter, String parameter, Object parameterValue, Integer value, int expected_count)
    {
        tx.begin();
        runQuery(pm, filter, parameter, parameterValue, ASSERTION_FAILED);
        if( query_result == null )
            return;
        Iterator iter = query_result.iterator();
        int cnt = 0;
        while( iter.hasNext() ){
            AllTypes obj = (AllTypes) iter.next();
            Integer val = obj.getInteger();
            if( !val.equals(value) ){
                fail(ASSERTION_FAILED, "JDOQL Equality test returns incorrect value, retrieved value: " + val + ", with parameter value: " + value, filter, parameter);
            }
            cnt++;
        }
        if( cnt != expected_count ){
            fail(ASSERTION_FAILED, "JDOQL Equality test returns wrong number of instances, expected " + expected_count + ", got " + cnt, filter, parameter);
        }
        query.close(query_result);
        tx.rollback();
    }

    private void run_LongQuery(String filter, String parameter, Object parameterValue, Long value, int expected_count)
    {
        tx.begin();
        runQuery(pm, filter, parameter, parameterValue, ASSERTION_FAILED);
        if( query_result == null )
            return;
        Iterator iter = query_result.iterator();
        int cnt = 0;
        while( iter.hasNext() ){
            AllTypes obj = (AllTypes) iter.next();
            Long val = obj.getLong();
            if( !val.equals(value) ){
                fail(ASSERTION_FAILED, "JDOQL Equality test returns incorrect value, retrieved value: " + val + ", with parameter value: " + value, filter, parameter);
            }
            cnt++;
        }
        if( cnt != expected_count ){
            fail(ASSERTION_FAILED, "JDOQL Equality test returns wrong number of instances, expected " + expected_count + ", got " + cnt, filter, parameter);
        }
        query.close(query_result);
        tx.rollback();
    }

    private void run_FloatQuery(String filter, String parameter, Object parameterValue, Float value, int expected_count)
    {
        tx.begin();
        runQuery(pm, filter, parameter, parameterValue, ASSERTION_FAILED);
        if( query_result == null )
            return;
        Iterator iter = query_result.iterator();
        int cnt = 0;
        while( iter.hasNext() ){
            AllTypes obj = (AllTypes) iter.next();
            Float val = obj.getFloat();
            if( !val.equals(value) ){
                fail(ASSERTION_FAILED, "JDOQL Equality test returns incorrect value, retrieved value: " + val + ", with parameter value: " + value, filter, parameter);
            }
            cnt++;
        }
        if( cnt != expected_count ){
            fail(ASSERTION_FAILED, "JDOQL Equality test returns wrong number of instances, expected " + expected_count + ", got " + cnt, filter, parameter);
        }
        query.close(query_result);
        tx.rollback();
    }

    private void run_DoubleQuery(String filter, String parameter, Object parameterValue, Double value, int expected_count)
    {
        tx.begin();
        runQuery(pm, filter, parameter, parameterValue, ASSERTION_FAILED);
        if( query_result == null )
            return;
        Iterator iter = query_result.iterator();
        int cnt = 0;
        while( iter.hasNext() ){
            AllTypes obj = (AllTypes) iter.next();
            Double val = obj.getDouble();
            if( !val.equals(value) ){
                fail(ASSERTION_FAILED, "JDOQL Equality test returns incorrect value, retrieved value: " + val + ", with parameter value: " + value, filter, parameter);
            }
            cnt++;
        }
        if( cnt != expected_count ){
            fail(ASSERTION_FAILED, "JDOQL Equality test returns wrong number of instances, expected " + expected_count + ", got " + cnt, filter, parameter);
        }
        query.close(query_result);
        tx.rollback();
    }

    private void run_StringQuery(String filter, String parameter, Object parameterValue, String value, int expected_count)
    {
        tx.begin();
        runQuery(pm, filter, parameter, parameterValue, ASSERTION_FAILED);
        if( query_result == null )
            return;
        Iterator iter = query_result.iterator();
        int cnt = 0;
        while( iter.hasNext() ){
            AllTypes obj = (AllTypes) iter.next();
            String val = obj.getString();
            if( !val.equals(value) ){
                fail(ASSERTION_FAILED, "JDOQL Equality test returns incorrect value, retrieved value: " + val + ", with parameter value: " + value, filter, parameter);
            }
            cnt++;
        }
        if( cnt != expected_count ){
            fail(ASSERTION_FAILED, "JDOQL Equality test returns wrong number of instances, expected " + expected_count + ", got " + cnt, filter, parameter);
        }
        query.close(query_result);
        tx.rollback();
    }

    private void run_LocaleQuery(String filter, String parameter, Object parameterValue, Locale value, int expected_count)
    {
        tx.begin();
        runQuery(pm, filter, parameter, parameterValue, ASSERTION_FAILED);
        if( query_result == null )
            return;
        Iterator iter = query_result.iterator();
        int cnt = 0;
        while( iter.hasNext() ){
            AllTypes obj = (AllTypes) iter.next();
            Locale val = obj.getLocale();
            if( !val.equals(value) ){
                fail(ASSERTION_FAILED, "JDOQL Equality test returns incorrect value, retrieved value: " + val + ", with parameter value: " + value, filter, parameter);

            }
            cnt++;
        }
        if( cnt != expected_count ){
            fail(ASSERTION_FAILED, "JDOQL Equality test returns wrong number of instances, expected " + expected_count + ", got " + cnt, filter, parameter);
        }
        query.close(query_result);
        tx.rollback();
    }

    private void run_BigDecimalQuery(String filter, String parameter, Object parameterValue, BigDecimal value, int expected_count)
    {
        tx.begin();
        runQuery(pm, filter, parameter, parameterValue, ASSERTION_FAILED);
        if( query_result == null )
            return;
        Iterator iter = query_result.iterator();
        int cnt = 0;
        while( iter.hasNext() ){
            AllTypes obj = (AllTypes) iter.next();
            BigDecimal val = obj.getBigDecimal();
//        if( !val.equals(value) ){
            if( val.compareTo(value) != 0 ){
                fail(ASSERTION_FAILED, "JDOQL Equality test returns incorrect value, retrieved value: " + val + ", with parameter value: " + value, filter, parameter);
            }
            cnt++;
        }
        if( cnt != expected_count ){
            fail(ASSERTION_FAILED, "JDOQL Equality test returns wrong number of instances, expected " + expected_count + ", got " + cnt, filter, parameter);
        }
        query.close(query_result);
        tx.rollback();
    }

    private void run_BigIntegerQuery(String filter, String parameter, Object parameterValue, BigInteger value, int expected_count)
    {
        tx.begin();
        runQuery(pm, filter, parameter, parameterValue, ASSERTION_FAILED);
        if( query_result == null )
            return;
        Iterator iter = query_result.iterator();
        int cnt = 0;
        while( iter.hasNext() ){
            AllTypes obj = (AllTypes) iter.next();
            BigInteger val = obj.getBigInteger();
            if( !val.equals(value) ){
                fail(ASSERTION_FAILED, "JDOQL Equality test returns incorrect value, retrieved value: " + val + ", with parameter value: " + value, filter, parameter);
            }
            cnt++;
        }
        if( cnt != expected_count ){
            fail(ASSERTION_FAILED, "JDOQL Equality test returns wrong number of instances, expected " + expected_count + ", got " + cnt, filter, parameter);
        }
        query.close(query_result);
        tx.rollback();
    }

    private void run_DateQuery(String filter, String parameter, Object parameterValue, Date value, int expected_count)
    {
        tx.begin();
        runQuery(pm, filter, parameter, parameterValue, ASSERTION_FAILED);
        if( query_result == null )
            return;
        Iterator iter = query_result.iterator();
        int cnt = 0;
        while( iter.hasNext() ){
            AllTypes obj = (AllTypes) iter.next();
            Date val = obj.getDate();
            if( !val.equals(value) ){
                fail(ASSERTION_FAILED, "JDOQL Equality test returns incorrect value, retrieved value: " + val + ", with parameter value: " + value, filter, parameter);
            }
            cnt++;
        }
        if( cnt != expected_count ){
            fail(ASSERTION_FAILED, "JDOQL Equality test returns wrong number of instances", filter, parameter);
        }
        query.close(query_result);
        tx.rollback();
    }

    /** */
    protected void localSetUp() {
        addTearDownClass(AllTypes.class);
        AllTypes.load(getPM());
    }
}
