package com.gzem2.JSPCalc.CalcService;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Implementation for service that performs calculator functions.
 */
public class CalcServiceImpl implements CalcService {

    /**
     * Parse input string and return calculated result
     */
    public Double calculateInput(String input) {
        List<String> inputParts = new ArrayList<String>();

        Matcher numsMatcher = Pattern.compile("(?<!\\d)([-]?\\d*\\.?\\d+)").matcher(input);
        while(numsMatcher.find()) {
            inputParts.add(numsMatcher.group(0));
        }

        Matcher m = Pattern.compile("\\d([-+*\\/])").matcher(input);

        Double result = 0.0;
        String op;
        Boolean nextOp = m.find();
        Boolean start = false;

        if (nextOp) {
            for (String p : inputParts) {
                if (!start) {
                    start = true;
                    op = m.group(1);
                    result = Double.parseDouble(p);
                } else {
                    op = m.group(1);
                    nextOp = m.find();
                    Double num = Double.parseDouble(p);
                    switch (op) {
                        case "-":
                            result = result - num;
                            break;
                        case "+":
                            result = result + num;
                            break;
                        case "*":
                            result = result * num;
                            break;
                        case "/":
                            if (num == 0.0)
                                return null;
                            result = result / num;
                            break;
                    }
                }
            }
        }

        return result;
    }
}
