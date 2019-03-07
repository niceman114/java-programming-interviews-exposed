<html>
<head>
    <title>Planet Diameters</title>
</head>
<body>
<#list diameters?keys as planet>
    <b>${planet}</b>: ${diameters[planet]}<br/>
</#list>
This page was generated on <i>${now?datetime}</i>
</body>
</html>