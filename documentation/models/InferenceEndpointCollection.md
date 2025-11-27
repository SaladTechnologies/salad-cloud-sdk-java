# InferenceEndpointCollection

Represents a page from the collection of inference endpoints.

**Properties**

| Name      | Type                                            | Required | Description                                  |
| :-------- | :---------------------------------------------- | :------- | :------------------------------------------- |
| items     | List<[InferenceEndpoint](InferenceEndpoint.md)> | ✅       | The list of inference endpoints.             |
| page      | Long                                            | ✅       | The page number.                             |
| pageSize  | Long                                            | ✅       | The maximum number of items per page.        |
| totalSize | Long                                            | ✅       | The total number of items in the collection. |
