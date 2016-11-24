/**
 * 
 */
package neu.sxc.expression.test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import neu.sxc.expression.Expression;
import neu.sxc.expression.ExpressionFactory;
import neu.sxc.expression.tokens.Valuable;

/** 
* @ClassName: ScriptManagerTest 
* @Description: 
* @author chaoqiang.zhou
* @date 2016年11月4日 下午2:52:47 
*  
*/
public class ScriptManagerTest {

    public static void test1() throws Exception {
        //TRUE
        String json = "(user1==2000 || user2==2000) && (user3==2000 || user4==2000)";
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
        engine.put("user1", 2000);
        engine.put("user2", "lisi");
        engine.put("user3", 2000);
        engine.put("user4", "zhangsan");
        engine.eval("RESULTCONDITION = (" + json + ")");
        System.out.println(Boolean.valueOf("" + engine.get("RESULTCONDITION")));
    }

    public static void test2() throws Exception {
        //TRUE
        String json = "(user1<\"2000\" || user1=\"2000\") && (user1=\"2000\" || user1=\"2000\")";
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
        engine.put("user1", "1000");
        engine.put("user2", "lisi");
        engine.put("user3", "2000");
        engine.put("user4", "zhangsan");
        engine.eval("RESULTCONDITION = (" + json + ")");
        System.out.println(Boolean.valueOf("" + engine.get("RESULTCONDITION")));
    }

    public static void test3() throws Exception {
        String json = "(user1==\"zhangsan\" || user2==\"lisi\") && (user3==\"wangwu\" || user4==\"liliu\")";
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
        engine.put("user1", 2000);
        engine.put("user2", "lisi");
        engine.put("user3", 2000);
        engine.put("user4", "zhangsan");
        engine.eval("RESULTCONDITION = (" + json + ")");
        System.out.println(Boolean.valueOf("" + engine.get("RESULTCONDITION")));
    }

    public static void test() throws ScriptException {
        String str = "(a or b) and c";
        str = str.replaceAll("or", "||");
        str = str.replaceAll("and", "&&");
        System.out.println(str);
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        engine.put("a", true);
        engine.put("b", false);
        engine.put("c", true);
        Object result = engine.eval(str);
        System.out.println("结果类型:" + result.getClass().getName() + ",计算结果:" + result);
    }

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

    public static void main(String[] args) throws Exception {
        test13();
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
        String json = "(a12==\"12\" || a13==\"13\") && (a14==\"14\" || a15==\"15\");";
        Expression exp = factory.getExpression(json);
        exp.setVariableValue("a12", "12");
        exp.setVariableValue("a13", "");
        exp.setVariableValue("a14", "");
        exp.setVariableValue("a15", "15");
        Valuable result = exp.evaluate();

        System.out.println(result.getBooleanValue());

    }

}
