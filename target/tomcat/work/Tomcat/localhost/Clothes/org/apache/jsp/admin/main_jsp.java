/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-06-06 06:36:25 UTC
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

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>xxxxx系统</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/bootstrap.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/AdminLTE.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/_all-skins.min.css\">\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.min.js\"></script>\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/bootstrap.js\"></script>\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/app.js\"></script>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        function SetIFrameHeight() {\n");
      out.write("            var iframeid = document.getElementById(\"iframe\");\n");
      out.write("            if (document.getElementById) {\n");
      out.write("                /*设置 内容展示区的高度等于页面可视区的高度*/\n");
      out.write("                iframeid.height = document.documentElement.clientHeight;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body class=\"hold-transition skin-green sidebar-mini\">\n");
      out.write("<div class=\"wrapper\">\n");
      out.write("    <!-- 页面头部 -->\n");
      out.write("    <header class=\"main-header\">\n");
      out.write("        <!-- Logo -->\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/main.jsp\" class=\"logo\">\n");
      out.write("            <span class=\"logo-lg\"><b>xxxxx系统</b></span>\n");
      out.write("        </a>\n");
      out.write("        <!-- 头部导航 -->\n");
      out.write("        <nav class=\"navbar navbar-static-top\">\n");
      out.write("            <div class=\"navbar-custom-menu\">\n");
      out.write("                <ul class=\"nav navbar-nav\">\n");
      out.write("                    <li class=\"dropdown user user-menu\">\n");
      out.write("                        <a>\n");
      out.write("                            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/img/Sauron.jpg\" class=\"user-image\"\n");
      out.write("                                 alt=\"User Image\">\n");
      out.write("                            <span class=\"hidden-xs\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${USER.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"dropdown user user-menu\">\n");
      out.write("                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/logout\">\n");
      out.write("                            <span class=\"hidden-xs\">注销</span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("    </header>\n");
      out.write("    <!-- 页面头部 /-->\n");
      out.write("\n");
      out.write("    <!-- 导航侧栏 -->\n");
      out.write("    <aside class=\"main-sidebar\">\n");
      out.write("        <!-- sidebar: style can be found in sidebar.less -->\n");
      out.write("        <section class=\"sidebar\">\n");
      out.write("            <!-- /.search form -->\n");
      out.write("            <!-- sidebar menu: : style can be found in sidebar.less -->\n");
      out.write("            <ul class=\"sidebar-menu\">\n");
      out.write("                <li id=\"admin-index\">\n");
      out.write("                    <a href=\"main.jsp\">\n");
      out.write("                        <i class=\"fa fa-dashboard\"></i> <span>首页</span>\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <!-- 用户管理 -->\n");
      out.write("                <li id=\"admin-login\">\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/search\" target=\"iframe\">\n");
      out.write("                        <i class=\"fa fa-circle-o\"></i>用户管理\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <!-- 货号管理 -->\n");
      out.write("                <li id=\"goods-manage\">\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/goods/search\" target=\"iframe\">\n");
      out.write("                        <i class=\"fa fa-circle-o\"></i>货号管理\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <!-- 库存管理 -->\n");
      out.write("                <li class=\"treeview\">\n");
      out.write("                    <a href=\"#\">\n");
      out.write("                        <i class=\"fa fa-folder\"></i>\n");
      out.write("                        <span>库存管理</span>\n");
      out.write("                        <span class=\"pull-right-container\">\n");
      out.write("\t\t\t\t       \t\t\t<i class=\"fa fa-angle-left pull-right\"></i>\n");
      out.write("\t\t\t\t   \t\t \t</span>\n");
      out.write("                    </a>\n");
      out.write("                    <ul class=\"treeview-menu\">\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/goodsIn/search\" target=\"iframe\">\n");
      out.write("                                <i class=\"fa fa-circle-o\"></i>入库管理\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/book/searchBorrowed\" target=\"iframe\">\n");
      out.write("                                <i class=\"fa fa-circle-o\"></i>出库管理\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("        <!-- /.sidebar -->\n");
      out.write("    </aside>\n");
      out.write("    <!-- 导航侧栏 /-->\n");
      out.write("    <!-- 内容展示区域 -->\n");
      out.write("    <div class=\"content-wrapper\" >\n");
      out.write("            ");
      out.write("\n");
      out.write("        <iframe  width=\"100%\" id=\"iframe\" name=\"iframe\" onload=\"SetIFrameHeight()\" frameborder=\"0\" >\n");
      out.write("        </iframe>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
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
