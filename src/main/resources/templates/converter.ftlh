<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>converter</title>
</head>
<body>
<div id="header">
    <h2>FreeMarker Spring MVC numbers converter</h2>
</div>

<div id="content">

    <form action="/converter" method="post">
        <div>Value:</div>
        <input type="text" name="value"/>
        <br/><br/>
        <input type="submit" value="Submit"/>
        <input type="reset" value="Reset"/>
    </form>
    <#if number?? && noErrors??>
        Your submitted number and conversion to hexadecimal<br>
        Decimal: ${number.getValue()}<br>
        Hexadecimal: ${number.toHex().getValue()}<br>
    <#else>

    </#if>

</div>

</body>
</html>