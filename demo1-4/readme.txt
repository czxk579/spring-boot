/*
* @Description: Swagger接口分类与各元素排序问题详解
* 参考：https://blog.didispace.com/spring-boot-learning-21-2-4/
* @Author: show.chen
* @Date: 2023/5/28 3:06 PM
*/


1、自定义默认分组的名称
    通过@Api注解来自定义Tag

2、合并Controller分组
    比如我们可以定义一个Tag为“教学管理”，让这个分组同时包含教师管理和学生管理的所有接口，可以这样来实现：
    @Api(tags = {"教师管理", "教学管理"})
    @RestController
    @RequestMapping(value = "/teacher")
    static class TeacherController {

        // ...

    }

    @Api(tags = {"学生管理", "教学管理"})
    @RestController
    @RequestMapping(value = "/student")
    static class StudentController {

        // ...

    }

3、更细粒度的接口分组
比如这样的需求：“教学管理”包含“教师管理”中所有接口以及“学生管理”管理中的“获取学生清单”接口（不是全部接口）。
可以这样来实现：
    @Api(tags = {"教师管理","教学管理"})
    @RestController
    @RequestMapping(value = "/teacher")
    static class TeacherController {

        @ApiOperation(value = "xxx")
        @GetMapping("/xxx")
        public String xxx() {
            return "xxx";
        }

    }

    @Api(tags = {"学生管理"})
    @RestController
    @RequestMapping(value = "/student")
    static class StudentController {

        @ApiOperation(value = "获取学生清单", tags = "教学管理")
        @GetMapping("/list")
        public String bbb() {
            return "bbb";
        }

        @ApiOperation("获取教某个学生的老师清单")
        @GetMapping("/his-teachers")
        public String ccc() {
            return "ccc";
        }

        @ApiOperation("创建一个学生")
        @PostMapping("/aaa")
        public String aaa() {
            return "aaa";
        }

    }


4、内容的顺序
    主要涉及三个方面：分组的排序、接口的排序以及参数的排序，其中，接口的排序以及参数的排序好像没有生效

