env $(cat .env | xargs) java -javaagent:./newrelic/newrelic.jar -jar build/libs/CloudCostInspector.jar

