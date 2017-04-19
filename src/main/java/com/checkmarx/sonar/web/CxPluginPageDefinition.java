package com.checkmarx.sonar.web;

import org.sonar.api.web.page.Context;
import org.sonar.api.web.page.Page;
import org.sonar.api.web.page.Page.Scope;
import org.sonar.api.web.page.PageDefinition;

public class CxPluginPageDefinition implements PageDefinition {

  @Override
  public void define(Context context) {
    context
      .addPage(Page.builder("example/custom_page_4_project")
        .setName("Custom Project Page")
        .setScope(Scope.COMPONENT).build())
      .addPage(Page.builder("example/custom_page_4_admin")
        .setName("Custom Admin Page")
        .setScope(Scope.COMPONENT)
        .setAdmin(Boolean.TRUE).build())
      .addPage(Page.builder("example/custom_page_global")
        .setName("Custom Global Page")
        .setScope(Scope.GLOBAL).build());
  }
}
