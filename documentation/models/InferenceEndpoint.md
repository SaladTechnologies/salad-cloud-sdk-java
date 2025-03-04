# InferenceEndpoint

Represents an inference endpoint

**Properties**

| Name             | Type   | Required | Description                                                                 |
| :--------------- | :----- | :------- | :-------------------------------------------------------------------------- |
| id               | String | ✅       | The inference endpoint identifier.                                          |
| name             | String | ✅       | The inference endpoint name.                                                |
| organizationName | String | ✅       | The organization name.                                                      |
| displayName      | String | ✅       | The display-friendly name of the resource.                                  |
| description      | String | ✅       | The detailed description of the resource.                                   |
| readme           | String | ✅       | A markdown file containing a detailed description of the inference endpoint |
| priceDescription | String | ✅       | A description of the price                                                  |
| iconUrl          | String | ✅       | The URL of the icon image                                                   |
| inputSchema      | String | ✅       | The input schema                                                            |
| outputSchema     | String | ✅       | The output schema                                                           |
