/*
 * Example Plugin for SonarQube
 * Copyright (C) 2009-2016 SonarSource SA
 * mailto:contact AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package com.checkmarx.sonar;

import com.checkmarx.sonar.cxportalservice.sast.services.CxConfigSoapService;
import com.checkmarx.sonar.cxrules.CxRulesDefinition;
import com.checkmarx.sonar.measures.ComputeSastMeasures;
import com.checkmarx.sonar.measures.OsaMetrics;
import com.checkmarx.sonar.measures.SastMetrics;
import com.checkmarx.sonar.sensor.CheckmarxSensor;
import com.checkmarx.sonar.settings.CxProperties;
import com.checkmarx.sonar.web.CxConfigRestEndPoint;
import com.checkmarx.sonar.web.CxPluginPageDefinition;
import org.sonar.api.Plugin;

public class CheckmarxPlugin implements Plugin {

  @Override
  public void define(Context context) {

    context.addExtensions(SastMetrics.class, ComputeSastMeasures.class, CxConfigSoapService.class, CheckmarxSensor.class,
                    OsaMetrics.class, CxProperties.getProperties(), CxPluginPageDefinition.class, CxConfigRestEndPoint.class, CxRulesDefinition.class);

  }
}
