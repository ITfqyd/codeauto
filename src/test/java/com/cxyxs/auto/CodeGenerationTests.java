package com.cxyxs.auto;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：
 * Author: wude
 * Date:  2020/4/5 9:14
 * Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CodeGenerationTests {
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //当前路径
        String projectPath = System.getProperty("user.dir");
        //输出路径
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("程序猿学社");    //设置作者
        //生成代码后，是否打开文件夹
        gc.setOpen(false);
        gc.setFileOverride(false);  //是否覆盖原来代码，个人建议设置为false,别覆盖，危险系数太高
        gc.setServiceName("%sService");   //去掉service的I前缀,一般只需要设置service就行
/*        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");*/

        gc.setDateType(DateType.ONLY_DATE);   //日期格式
        gc.setSwagger2(true);       // 实体属性 Swagger2 注解,实体类上会增加注释
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/pro?useUnicode=true&characterEncoding=utf8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setDbType(DbType.MYSQL);    //指定数据库的类型
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.cxyxs.auto");   //自定义包的路径
        //pc.setModuleName("module");   //模块名称  设置后,会生成com.cxyxs.test.module,里面存放之前设置的mapper,entity
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("student");    //设置映射的表名，可以设置多个表

        //表前缀设置  cxyxs_student
        //strategy.setTablePrefix(new String[]{"cxyxs_"});
        //包的命名规则，使用驼峰规则
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //列的名称，使用驼峰规则
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //是否使用lombok
        strategy.setEntityLombokModel(true);
        //驼峰命名
        strategy.setRestControllerStyle(true);
        strategy.setLogicDeleteFieldName("is_delete");   //逻辑删除,假删除会用到

        //自动填充字段,在项目开发过程中,例如创建时间，修改时间,每次，都需要我们来指定，太麻烦了,设置为自动填充规则，就不需要我们赋值咯
        TableFill fillInsert = new TableFill("create_time", FieldFill.INSERT);
        TableFill fillUpdate= new TableFill("update_time", FieldFill.UPDATE);
        List fillLists = new ArrayList();
        fillLists.add(fillInsert);
        fillLists.add(fillUpdate);
        strategy.setTableFillList(fillLists);
        //乐观锁
        //strategy.setVersionFieldName("version");
        mpg.setStrategy(strategy);

        mpg.execute();  //执行
    }
}
