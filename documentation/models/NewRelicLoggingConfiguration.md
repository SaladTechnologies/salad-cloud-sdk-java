# NewRelicLoggingConfiguration

Configuration for sending container logs to New Relic's log management platform.

**Properties**

| Name         | Type   | Required | Description                                                                      |
| :----------- | :----- | :------- | :------------------------------------------------------------------------------- |
| host         | String | ✅       | The New Relic endpoint host for log ingestion (e.g., log-api.newrelic.com).      |
| ingestionKey | String | ✅       | The New Relic license or ingestion key used for authentication and data routing. |
