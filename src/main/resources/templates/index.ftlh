<#import "/spring.ftl" as spring />
<#function if cond then="" else="">
    <#if cond>
        ${then}
    <#else>
        ${else}
    </#if>
</#function>

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
    <title>converter</title>

</head>

<body>
<div id="header" class="jumbotron text-center bg-primary w-50 mx-auto">
    <h2 class="text-light">Numbers Converter</h2>

</div>

<div id="content" class="contentContainer w-75 mx-auto" style="background-color: aliceblue">

    <form action="/index" method="post" class="d-flex">
        <div class="p-2 flex-fill justify-content-center">
            <div>From notation:</div>
            <select disabled="disabled" type="text" name="notationFrom" class="form-select w-75"
                    aria-label="Default select example">
                <option selected="selected" value="${conversionData.getNotationFrom()!'10'}">${conversionData.getNotationFrom()!'10'}</option>
                <#list handledNotations>
                    <#items as notation>
                        <#if notation != conversionData.getNotationFrom()!'10'>
                            <option value=${notation}>${notation}</option>
                        </#if>
                    </#items>
                </#list>
            </select>
            <div>Value:</div>
            <label>
                <input type="text" name="value" value="${conversionData.getValue()!''}" placeholder="pass some number"/>
            </label>
        </div>

        <div class="p-2 flex-fill justify-content-center">
            <input type="submit" value="convert to"/>
        </div>
        <div class="p-2 flex-fill justify-content-center">
            <div>notation:</div>
            <select type="text" name="notationTo" class="form-select w-75" aria-label="Default select example">
                <option selected="selected" value="${conversionData.getNotationTo()!'16'}">${conversionData.getNotationTo()!'16'}</option>
                <#list handledNotations>
                    <#items as notation>
                        <#if notation != conversionData.getNotationTo()!'16'>
                            <option value=${notation}>${notation}</option>
                        </#if>
                    </#items>
                </#list>
            </select>
            <div>
                <#if number?? && noErrors??>
                    Converted to ${number.getNotation()} notation<br>
                    ${number.getValue()}<br>
                </#if>
            </div>
        </div>
    </form>


</div>

</body>
</html>