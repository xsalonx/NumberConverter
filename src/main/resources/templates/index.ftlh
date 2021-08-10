<#import "/spring.ftl" as spring />
<#--<#function if cond then="" else="">-->
<#--    <#if cond>-->
<#--        ${then}-->
<#--    <#else>-->
<#--        ${else}-->
<#--    </#if>-->
<#--</#function>-->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="Łukasz Dubiel">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
            crossorigin="anonymous"></script>
    <title>NumberConverter</title>

    <script>
        function convertReq() {
            const notationFrom = document.getElementById("select-notation-from").value;
            const notationTo = document.getElementById("select-notation-to").value;
            const value = document.getElementById("input-value").value;
            const req = new XMLHttpRequest()
            console.log(notationTo, notationFrom, value);
            req.open("GET", 'converter/?value=' + value + '&notationFrom=' + notationFrom + '&notationTo=' + notationTo, false);
            req.send(null);
            const resp = req.response
            console.log(resp);
            alert(resp);
            const converterValue = document.getElementById("convertedValue");
            converterValue.innerHTML = resp.value;
        }
    </script>
</head>

<body>
<div id="header" class="jumbotron text-center bg-primary w-75 mx-auto">
    <h2 class="text-light">Numbers Converter</h2>

</div>

<div id="content" class="contentContainer w-75 mx-auto" style="background-color: aliceblue">
    <div id="conversionForm" method="get" class="d-md-flex">
        <div class="p-2 flex-fill align-top">
            <div>From notation:</div>
            <select id="select-notation-from" disabled="disabled" type="text" name="notationFrom" class="form-select w-50"
                    aria-label="Default select example" data-toggle="tooltip"
                    title="TODO logged user will be able to use rest functionality">
                <option selected="selected"
                        value="10">10
                </option>
                <#list handledNotations>
                    <#items as notation>
                        <#if notation != '10'>
                            <option value=${notation}>${notation}</option>
                        </#if>
                    </#items>
                </#list>
            </select>
            <div>Value:</div>
            <label class="w-50">
                <input id="input-value" type="text" name="value" placeholder="pass some number"/>
            </label>
        </div>
        <div class="p-2 pt-2 flex-fill justify-content-center align-items-center">
            <label>
                <button onclick="convertReq()">convert</button>
            </label>
        </div>
        <div class="p-2 flex-fill align-top">
            <div>to notation:</div>
            <select id="select-notation-to" type="text" name="notationTo" class="form-select w-50" aria-label="Default select example">
                <option selected="selected"
                        value="16">16
                </option>
                <#list handledNotations>
                    <#items as notation>
                        <#if notation != '16'>
                            <option value=${notation}>${notation}</option>
                        </#if>
                    </#items>
                </#list>
            </select>
            <div class="w-50">
                <div>Value:</div>
                <label class="w-50">
                    <textarea id="convertedValue" readonly="readonly"></textarea>
                </label>

            </div>
        </div>
    </div>
</div>

</body>
</html>