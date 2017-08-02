package com.checkmarx.sonar.web;

import org.sonar.api.web.page.Context;
import org.sonar.api.web.page.Page;
import org.sonar.api.web.page.Page.Scope;
import org.sonar.api.web.page.PageDefinition;

public class CxPluginPageDefinition implements PageDefinition {

  @Override
  public void define(Context context) {
    context
      .addPage(Page.builder("checkmarx/project_configuration")
              .setName("Checkmarx")
              .setScope(Scope.COMPONENT)
              .setAdmin(Boolean.TRUE).build())
      .addPage(Page.builder("checkmarx/cx_report")
        .setName("Checkmarx Report")
        .setScope(Scope.COMPONENT).build());
  }
}
