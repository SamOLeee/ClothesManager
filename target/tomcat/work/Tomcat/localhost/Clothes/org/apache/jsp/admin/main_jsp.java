/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-06-15 06:28:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title>服装库存管理系统</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/bootstrap.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/AdminLTE.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/_all-skins.min.css\">\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/bootstrap.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/app.js\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/my.js\"></script>\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/timeout.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        function SetIFrameHeight() {\r\n");
      out.write("            var iframeid = document.getElementById(\"iframe\");\r\n");
      out.write("            if (document.getElementById) {\r\n");
      out.write("                /*设置 内容展示区的高度等于页面可视区的高度*/\r\n");
      out.write("                iframeid.height = document.documentElement.clientHeight;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"hold-transition skin-green sidebar-mini\">\r\n");
      out.write("<div class=\"wrapper\">\r\n");
      out.write("    <!-- 页面头部 -->\r\n");
      out.write("    <header class=\"main-header\">\r\n");
      out.write("        <!-- Logo -->\r\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/goods/getAllGoodsIn\" class=\"logo\">\r\n");
      out.write("\r\n");
      out.write("            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/img/logo.png\" class=\"logo\">\r\n");
      out.write("        </a>\r\n");
      out.write("        <!-- 头部导航 -->\r\n");
      out.write("        <nav class=\"navbar navbar-static-top\">\r\n");
      out.write("            <div class=\"navbar-custom-menu\">\r\n");
      out.write("                <ul class=\"nav navbar-nav\">\r\n");
      out.write("                    <li class=\"dropdown user user-menu\" >\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-block btn-success\" title=\"个人中心\" data-toggle=\"modal\"\r\n");
      out.write("                                data-target=\"#UserCenterModal\" onclick=\"resetUserCenterFrom()\"><i class=\"fa fa-file-o\"></i>\r\n");
      out.write("                            <a>\r\n");
      out.write("                                <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/img/Sauron.jpg\" class=\"user-image\"\r\n");
      out.write("                                     alt=\"User Image\">\r\n");
      out.write("                                <span class=\"hidden-xs\"><font color=\"white\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${USER.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</font></span>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </button>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"dropdown user user-menu\">\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-block btn-success\">\r\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/logout\">\r\n");
      out.write("                                <span class=\"hidden-xs\"><font color=\"white\">注销</font></span>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </button>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("    </header>\r\n");
      out.write("    <!-- 页面头部 /-->\r\n");
      out.write("\r\n");
      out.write("    <!-- 导航侧栏 -->\r\n");
      out.write("    <aside class=\"main-sidebar\">\r\n");
      out.write("        <!-- sidebar: style can be found in sidebar.less -->\r\n");
      out.write("        <section class=\"sidebar\">\r\n");
      out.write("            <!-- /.search form -->\r\n");
      out.write("            <!-- sidebar menu: : style can be found in sidebar.less -->\r\n");
      out.write("            <ul class=\"sidebar-menu\">\r\n");
      out.write("                <li id=\"admin-index\">\r\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/goods/getAllGoodsIn\">\r\n");
      out.write("                        <i class=\"fa fa-dashboard\"></i> <span>首页</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <!-- 用户管理 -->\r\n");
      out.write("                <li id=\"admin-login\">\r\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/search\" target=\"iframe\">\r\n");
      out.write("                        <i class=\"fa fa-circle-o\"></i>用户管理\r\n");
      out.write("                    </a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <!-- 货号管理 -->\r\n");
      out.write("                <li id=\"goods-manage\">\r\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/goods/search\" target=\"iframe\">\r\n");
      out.write("                        <i class=\"fa fa-circle-o\"></i>货号管理\r\n");
      out.write("                    </a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <!-- 库存管理 -->\r\n");
      out.write("                <li class=\"treeview\">\r\n");
      out.write("                    <a href=\"*\">\r\n");
      out.write("                        <i class=\"fa fa-folder\"></i>\r\n");
      out.write("                        <span>库存管理</span>\r\n");
      out.write("                        <span class=\"pull-right-container\">\r\n");
      out.write("\t\t\t\t       \t\t\t<i class=\"fa fa-angle-left pull-right\"></i>\r\n");
      out.write("\t\t\t\t   \t\t \t</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <ul class=\"treeview-menu\">\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/goodsIn/search\" target=\"iframe\">\r\n");
      out.write("                                <i class=\"fa fa-circle-o\"></i>入库管理\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/goodsOut/search\" target=\"iframe\">\r\n");
      out.write("                                <i class=\"fa fa-circle-o\"></i>出库管理\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/goodsDetail/searchAll\" target=\"iframe\">\r\n");
      out.write("                                <i class=\"fa fa-circle-o\"></i>所有明细\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </section>\r\n");
      out.write("\r\n");
      out.write("        <!-- /.sidebar -->\r\n");
      out.write("    </aside>\r\n");
      out.write("    <!-- 导航侧栏 /-->\r\n");
      out.write("    <!-- 内容展示区域 -->\r\n");
      out.write("    <div class=\"content-wrapper\">\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <iframe width=\"100%\" id=\"iframe\" name=\"iframe\" onload=\"SetIFrameHeight()\" frameborder=\"0\">\r\n");
      out.write("        </iframe>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- 个人中心修改密码 -->\r\n");
      out.write("<div class=\"modal fade\" id=\"UserCenterModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" >\r\n");
      out.write("    <div class=\"modal-dialog\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">×</button>\r\n");
      out.write("                <h3 id=\"myModalLabe2\">个人中心</h3>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("                <form id=\"UserCenter\">\r\n");
      out.write("                    ");
      out.write("\r\n");
      out.write("                    <table id=\"UserCenterTab\" class=\"table table-bordered table-striped\" width=\"800px\">\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>输入密码</td>\r\n");
      out.write("                            <td><input class=\"form-control\"  name=\"pw\" id=\"usrpw\" placeholder=\"输入密码\"\r\n");
      out.write("                                       onblur=\"checkUserVal()\" onfocus=\"changeUserVal()\"></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>再次输入密码</td>\r\n");
      out.write("                            <td><input class=\"form-control\"  name=\"password\" id=\"enusrpw\" placeholder=\"再次输入密码\"\r\n");
      out.write("                                       onblur=\"checkUserVal()\" onfocus=\"changeUserVal()\"></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td colspan=\"2\"><span style=\"color: red\" id=\"addUsermsg\"></span></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </table>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-footer\">\r\n");
      out.write("                <button class=\"btn btn-success\" data-dismiss=\"modal\" aria-hidden=\"true\" id=\"saveUsermsg\"\r\n");
      out.write("                        disabled=\"true\"\r\n");
      out.write("                        onclick=\"updateUserPwd(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${USER.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(")\">保存\r\n");
      out.write("                </button>\r\n");
      out.write("                <button class=\"btn btn-default btn-danger\" data-dismiss=\"modal\" aria-hidden=\"true\">关闭</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
