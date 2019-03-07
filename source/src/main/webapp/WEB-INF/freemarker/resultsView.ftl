<#import "/spring.ftl" as spring/>
<html>
<body>
  <h2>Results</h2>
<#list results as result>
    <b>${result.homeTeam}</b> ${result.homeTeamScore}-${result.awayTeamScore} <b>${result.awayTeam}</b><br/>
</#list>
</body>
</html>