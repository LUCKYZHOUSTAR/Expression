
package neu.sxc.expression.test;

import neu.sxc.expression.Expression;
import neu.sxc.expression.ExpressionFactory;
import neu.sxc.expression.tokens.Valuable;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author chaoqiang.zhou
 * @ClassName: ScriptManagerTest
 * @Description:
 * @date 2016年11月4日 下午2:52:47
 */
public class ScriptManagerTest {

//    public static void test1() throws Exception {
//        //TRUE
//        String json = "(user1==2000 || user2==2000) && (user3==2000 || user4==2000)";
//        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
//        engine.put("user1", 2000);
//        engine.put("user2", "lisi");
//        engine.put("user3", 2000);
//        engine.put("user4", "zhangsan");
//        engine.eval("RESULTCONDITION = (" + json + ")");
//        System.out.println(Boolean.valueOf("" + engine.get("RESULTCONDITION")));
//    }
//
//
//
//    public static void test112() throws Exception {
//        //TRUE
//        String json = "(user1==2000 || user2==2000) && (user3==2000 || user4==2000)";
//
//        String json2=""
//        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
//        engine.put("user1", 2000);
//        engine.put("user2", "lisi");
//        engine.put("user3", 2000);
//        engine.put("user4", "zhangsan");
//        engine.eval("RESULTCONDITION = (" + json + ")");
//        System.out.println(Boolean.valueOf("" + engine.get("RESULTCONDITION")));
//    }
//
//
//
//
//
//    public static void test2() throws Exception {
//        //TRUE
//        String json = "(user1<\"2000\" || user1=\"2000\") && (user1=\"2000\" || user1=\"2000\")";
//        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
//        engine.put("user1", "1000");
//        engine.put("user2", "lisi");
//        engine.put("user3", "2000");
//        engine.put("user4", "zhangsan");
//        engine.eval("RESULTCONDITION = (" + json + ")");
//        System.out.println(Boolean.valueOf("" + engine.get("RESULTCONDITION")));
//    }
//
//    public static void test3() throws Exception {
//        String json = "(user1==\"zhangsan\" || user2==\"lisi\") && (user3==\"wangwu\" || user4==\"liliu\")";
//        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
//        engine.put("user1", 2000);
//        engine.put("user2", "lisi");
//        engine.put("user3", 2000);
//        engine.put("user4", "zhangsan");
//        engine.eval("RESULTCONDITION = (" + json + ")");
//        System.out.println(Boolean.valueOf("" + engine.get("RESULTCONDITION")));
//    }
//
//    public static void test() throws ScriptException {
//        String str = "(a or b) and c";
//        str = str.replaceAll("or", "||");
//        str = str.replaceAll("and", "&&");
//        System.out.println(str);
//        ScriptEngineManager manager = new ScriptEngineManager();
//        ScriptEngine engine = manager.getEngineByName("js");
//        engine.put("a", true);
//        engine.put("b", false);
//        engine.put("c", true);
//        Object result = engine.eval(str);
//        System.out.println("结果类型:" + result.getClass().getName() + ",计算结果:" + result);
//    }

    public static void test6() {

        //TRUE
        String json = "(user1==\"zhangsan\");";
        ExpressionFactory factory = ExpressionFactory.getInstance();
        //        String condition = "user1=zhangsasn;user2=lisi;user3=wangwu;user4=liliu;";
        Expression exp = factory.getExpression(json);
        exp.setVariableValue("user1", "zhangsan");
        Valuable result = exp.evaluate();
        System.out.println(result.getBooleanValue());

    }

    public static void test7() {
        String json = "(user1==\"zhangsan\" || user2<=2000);";
        ExpressionFactory factory = ExpressionFactory.getInstance();
        //        String condition = "user1=zhangsasn;user2=lisi;user3=wangwu;user4=liliu;";
        Expression exp = factory.getExpression(json);
        exp.setVariableValue("user2", 3000);
        exp.setVariableValue("user1", "wagnwu");
        Valuable result = exp.evaluate();
        System.out.println(result.getBooleanValue());
    }

    public static void test9() {
        //变量的值一旦定义，则后面就不可以更改
        //字符串也支持数字的表达式计算,并且没有空格也没有关系
        //        String json = "(user1==\"zhangsan\"||user1<=\"2000\");";
        String json = "user1==\"zhangsan\";";
        ExpressionFactory factory = ExpressionFactory.getInstance();
        //        String condition = "user1=zhangsasn;user2=lisi;user3=wangwu;user4=liliu;";
        Expression exp = factory.getExpression(json);
        //        exp.setVariableValue("user2", "4000");
        exp.setVariableValue("user1", "zhangsan");
        //        exp.setVariableValue("user2", "zhangsan");
        //        exp.setVariableValue("count", 1000);
        Valuable result = exp.evaluate();
        System.out.println(result.getBooleanValue());
    }

    public static void test10() {
        //变量的值一旦定义，则后面就不可以更改
        //字符串也支持数字的表达式计算,并且没有空格也没有关系
        String json = "(user1==\"zhangsan\"||user2<=\"2000\")&&(user3>\"6000\"&&true);";
        ExpressionFactory factory = ExpressionFactory.getInstance();
        //String condition = "user1=zhangsasn;user2=lisi;user3=wangwu;user4=liliu;";
        Expression exp = factory.getExpression(json);
        exp.setVariableValue("user2", "1000");
        exp.setVariableValue("user1", "wagnwu");
        exp.setVariableValue("user3", "7000");
        Valuable result = exp.evaluate();
        System.out.println(result.getBooleanValue());
    }

    public static void test11() {
        String json = "(user1<=\"2000\");";
        ExpressionFactory factory = ExpressionFactory.getInstance();
        Expression exp = factory.getExpression(json);
        exp.setVariableValue("user1", "1000");
        Valuable result = exp.evaluate();
        System.out.println(result.getBooleanValue());
    }

    //审批流系统变量赋值
    public static void test8() {
        //变量的值一旦定义，则后面就不可以更改
        //字符串也支持数字的表达式计算
        String json = "(user1==\"zhangsan\" || user2<=\"2000\");";
        ExpressionFactory factory = ExpressionFactory.getInstance();
        //        String condition = "user1=zhangsasn;user2=lisi;user3=wangwu;user4=liliu;";
        Expression exp = factory.getExpression(json);
        exp.setVariableValue("user2", "1000");
        exp.setVariableValue("user1", "wagnwu");
        Valuable result = exp.evaluate();
        System.out.println(result.getBooleanValue());
    }


    public static void test3333() {
        String json = "start > [2012-03-01] && start<[2019-06-01];";

        ExpressionFactory factory = ExpressionFactory.getInstance();
        //        String condition = "user1=zhangsasn;user2=lisi;user3=wangwu;user4=liliu;";
        Expression exp = factory.getExpression(json);
        exp.setVariableValue("start", dataToCalendar(new Date()));
        Valuable result = exp.evaluate();
        System.out.println(result.getBooleanValue());
    }


    public static void test333344() {
        String json = "(start > [2012-03-01 15:33:43] && start<[2019-06-01 21:23:23])&&(city==\"123\"||city==\"234\");";

        ExpressionFactory factory = ExpressionFactory.getInstance();
        //        String condition = "user1=zhangsasn;user2=lisi;user3=wangwu;user4=liliu;";
        Expression exp = factory.getExpression(json);
        exp.setVariableValue("start", dataToCalendar(new Date()));
        exp.setVariableValue("city", "345");
        Valuable result = exp.evaluate();
        System.out.println(result.getBooleanValue());
    }

    public static void test3333446666() {


        //start > [2012-03-01 15:33:43]&&(city=="123"||city=="234"|| city=="all") ||  start > [2012-03-02 15:33:43]&&(city=="123"||city=="234"|| city=="all")

        //开始时间配置>=,结束时间配置<=
        String json = "(start > [2012-03-01 15:33:43]&&(city==\"123\"||city==\"234\"|| city==\"all\"))||(start > [2012-03-01 15:33:43]&&(city==\"123\"||city==\"234\"|| city==\"all\"))||(start > [2012-03-01 15:33:43]&&(city==\"123\"||city==\"234\"|| city==\"all\"));";

        ExpressionFactory factory = ExpressionFactory.getInstance();
        //        String condition = "user1=zhangsasn;user2=lisi;user3=wangwu;user4=liliu;";
        Expression exp = factory.getExpression(json);
        exp.setVariableValue("start", dataToCalendar(new Date()));
        exp.setVariableValue("city", "all");

        Valuable result = exp.evaluate();
        System.out.println(result.getBooleanValue());
    }


    public static void test33334466663333() {

        //开始时间配置>=,结束时间配置<=
        String json = "(start > [2012-03-01 15:33:43]&&(city==\"123\"||city==\"234\"|| city==\"all\"))&& (end<[2019-06-01 21:23:23]&&(city==\"567\"||city==\"453\"||city==\"all\"));";

        ExpressionFactory factory = ExpressionFactory.getInstance();
        //        String condition = "user1=zhangsasn;user2=lisi;user3=wangwu;user4=liliu;";
        Expression exp = factory.getExpression(json);
//        exp.setVariableValue("start", dataToCalendar(new Date()));
        exp.setVariableValue("city", "all");
        exp.setVariableValue("end", dataToCalendar(new Date()));

        Valuable result = exp.evaluate();
        System.out.println(result.getBooleanValue());
    }


    public static void main(String[] args) throws Exception {
//        String json = "(user1>>\"张三\");";
//
//        Scanner scanner = new Scanner(json);
//        System.out.println(scanner.nextLine());


//        StringBuilder sb = new StringBuilder();
//        sb.append("(city==\"123\"||city==\"234\"|| city==\"all\")");
//
//        for (int i = 0; i < 1000; i++) {
//            sb.append("(city==\"123\"||city==\"234\"|| city==\"all\")");
//
//        }
//
//        long start = System.currentTimeMillis();
//
//        long end = System.currentTimeMillis();
//        System.out.println((end - start) / 1000);

        //以回车符为换行符
        Scanner scanner = new Scanner("2342342,43234;,2345,{}345; sadfasdfasdfa sf" +
                "水电费as" +
                "水电费啊水电费");

        while (scanner.hasNextLine()) {
            char[] chars = scanner.nextLine().toCharArray();
//            System.out.println(scanner.nextLine().toCharArray());
//            System.out.println(scanner.nextLine().toCharArray());
//            System.out.println(discardComment(scanner.nextLine()));
            System.out.println("Sdfasf");
        }
        test345345();
    }

    private static String discardComment(String target) {
        Pattern commentPattern = Pattern.compile("##.*");
        Matcher matcher = commentPattern.matcher(target);
        return matcher.replaceFirst("");
    }


    //以。。。开始
    public static void test12() {
        String json = "(user1>>\"张三\");";
        ExpressionFactory factory = ExpressionFactory.getInstance();
        Expression exp = factory.getExpression(json);
        exp.setVariableValue("user1", "张三我是好人");
        Valuable result = exp.evaluate();
        System.out.println(result.getBooleanValue());
    }

    //以。。结束
    public static void test13() {
        String json = "(user1<<\"张三\");";
        ExpressionFactory factory = ExpressionFactory.getInstance();
        Expression exp = factory.getExpression(json);
        exp.setVariableValue("user1", "张三我是好人张三");
        Valuable result = exp.evaluate();
        System.out.println(result.getBooleanValue());
    }


    public static void test345345() {
        ExpressionFactory factory = ExpressionFactory.getInstance();

        Expression expression = factory.getExpression("1 + max(1,abs(-2)) + abs(-1);");

        Valuable result = expression.evaluate();
        System.out.println(result.getValue());

    }

    /**
     * @Title: test5
     * @Description: 普通审批里面条件
     * @author chaoqiang.zhou
     * @date 2016年11月21日 下午1:11:58
     */
    public static void test5() {
        //        String json = "(user1==zhangsan)";
        ExpressionFactory factory = ExpressionFactory.getInstance();
        //        String condition = "user1=zhangsasn;user2=lisi;user3=wangwu;user4=liliu;";
        //        String condition = "( 2>1  ||  false)   &&  (false  ||  1<2);";
//        String json = "(a12==\"12\");";
        String json = "(a12==\"12\");";

        Expression exp = factory.getExpression(json);
        exp.setVariableValue("a12", "12");
        exp.setVariableValue("a13", "");
        exp.setVariableValue("a14", "");
        exp.setVariableValue("a15", "15");
        Valuable result = exp.evaluate();

        System.out.println(result.getBooleanValue());

    }

    public static Calendar dataToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
