// Copyright (C) 2003-2009 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the CPL Common Public License version 1.0.
package fitnesse.testsystems.slim.tables;

import java.util.Collections;
import java.util.List;

import fitnesse.slim.instructions.Instruction;
import fitnesse.testsystems.slim.SlimTestContext;
import fitnesse.testsystems.slim.Table;
import fitnesse.testsystems.slim.results.Result;

public class SlimErrorTable extends SlimTable {
  public SlimErrorTable(Table table, String id, SlimTestContext testContext) {
    super(table, id, testContext);
  }

  protected String getTableType() {
    return "UnknownTableType";
  }

  public List<Instruction> getInstructions() {
	// No need for Expectations, this is just an errorous table. Put a notification in.
    String tableType = table.getCellContents(0, 0);
    Result errorMessage = fail(String.format("\"%s\" is not a valid table type.", tableType));
    table.setCell(0, 0, errorMessage);
    return Collections.emptyList();
  }
}
