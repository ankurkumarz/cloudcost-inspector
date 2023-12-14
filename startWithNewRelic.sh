env $(cat .env | xargs) java -javaagent:/Users/ankkumar/Sandbox/GitHub/cloudcost-inspector/newrelic/newrelic.jar -jar build/libs/CloudCostInspector.jar

