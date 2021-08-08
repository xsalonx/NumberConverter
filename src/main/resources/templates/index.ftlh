<#import "/spring.ftl" as spring />

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
<div id="header">
    <div class="fixedNav">
        <h2>FreeMarker Spring MVC numbers converter</h2>
    </div>
</div>

<div id="content" class="contentContainer">

    <form action="/index" method="post">
        <div>Value:</div>
        <input type="text" name="value"/>
        <div>Notation:</div>
        <select type="text" name="notationFrom" class="form-select" aria-label="Default select example">
            <#list handledNotations>
                <#items as notation>
                    <option value=${notation}>${notation}</option>
                </#items>
            </#list>
        </select>
        <br/><br/>
        <input type="submit" value="convert to"/>
        <select type="text" name="notationTo" class="form-select" aria-label="Default select example">
            <#list handledNotations>
                <#items as notation>
                    <option value=${notation}>${notation}</option>
                </#items>
            </#list>
        </select>
    </form>


    <#if number?? && noErrors??>
        Your submitted number and conversion to hexadecimal<br>
        Decimal: ${number.getValue()}<br>
    <#else>

    </#if>

</div>

</body>
</html>