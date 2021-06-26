<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>JSPCalc</title>
        <style>
            .calc {
                margin: 25px;
            }

            .display span {
                border: 1px solid;
                display: block;
                width: 200px;
                text-align: right;
                padding: 5px;
                margin-bottom: 5px;
            }

            .calc-button {
                width: 50px;
                height: 20px;
                margin-bottom: 2px;
            }

            .button-column {
                float: left;
                height: 50px;
                width: 54px;
            }

            .equals-button {
                height: 86px;
            }

            .calc:after {
                clear: both;
            }
        </style>

        <script>
            document.addEventListener("keypress", function (event) {
                switch (event.key) {
                    case "+":
                        document.getElementById("button_add").click();
                        break;
                    case "7":
                        document.getElementById("button_7").click();
                        break;
                    case "4":
                        document.getElementById("button_4").click();
                        break;
                    case "1":
                        document.getElementById("button_1").click();
                        break;
                    case "0":
                        document.getElementById("button_0").click();
                        break;
                    case "-":
                        document.getElementById("button_sub").click();
                        break;
                    case "8":
                        document.getElementById("button_8").click();
                        break;
                    case "5":
                        document.getElementById("button_5").click();
                        break;
                    case "2":
                        document.getElementById("button_2").click();
                        break;
                    case ".":
                        document.getElementById("button_dot").click();
                        break;
                    case "*":
                        document.getElementById("button_multiply").click();
                        break;
                    case "9":
                        document.getElementById("button_9").click();
                        break;
                    case "6":
                        document.getElementById("button_6").click();
                        break;
                    case "3":
                        document.getElementById("button_3").click();
                        break;
                    case "Backspace":
                    case "Delete":
                    case "c":
                    case "C":
                        document.getElementById("button_c").click();
                        break;
                    case "/":
                        document.getElementById("button_div").click();
                        break;
                    case "=":
                    case "Enter":
                        document.getElementById("button_eq").click();
                        break;
                }
            });
        </script>
    </head>

    <body>
        <div class="calc">
            <div class="display">
                <span id="display">${result}</span>
            </div>
            <div class="controls">
                <form action="${pageContext.request.contextPath}/" method="post">
                    <div class="button-column">
                        <button id="button_add" class="calc-button" name="button" type="submit" value="+">+</button>
                        <button id="button_7" class="calc-button" name="button" type="submit" value="7">7</button>
                        <button id="button_4" class="calc-button" name="button" type="submit" value="4">4</button>
                        <button id="button_1" class="calc-button" name="button" type="submit" value="1">1</button>
                        <button id="button_0" class="calc-button" name="button" type="submit" value="0">0</button>
                    </div>
                    <div class="button-column">
                        <button id="button_sub" class="calc-button" name="button" type="submit" value="-">-</button>
                        <button id="button_8" class="calc-button" name="button" type="submit" value="8">8</button>
                        <button id="button_5" class="calc-button" name="button" type="submit" value="5">5</button>
                        <button id="button_2" class="calc-button" name="button" type="submit" value="2">2</button>
                        <button id="button_dot" class="calc-button" name="button" type="submit" value=".">.</button>
                    </div>
                    <div class="button-column">
                        <button id="button_multiply" class="calc-button" name="button" type="submit"
                            value="*">&times;</button>
                        <button id="button_9" class="calc-button" name="button" type="submit" value="9">9</button>
                        <button id="button_6" class="calc-button" name="button" type="submit" value="6">6</button>
                        <button id="button_3" class="calc-button" name="button" type="submit" value="3">3</button>
                        <button id="button_c" class="calc-button" name="button" type="submit" value="C">C</button>
                    </div>
                    <div class="button-column">
                        <button id="button_div" class="calc-button" name="button" type="submit" value="/">&divide;</button>
                        <button id="button_eq" class="calc-button equals-button" name="button" type="submit"
                            value="=">=</button>
                    </div>
                </form>
            </div>
        </div>
    </body>

    </html>