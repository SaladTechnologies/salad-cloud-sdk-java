# GpuAvailabilityPrototype

**Properties**

| Name          | Type                                | Required | Description                                               |
| :------------ | :---------------------------------- | :------- | :-------------------------------------------------------- |
| gpuClasses    | List<String>                        | ✅       | A list of available GPU class names                       |
| countryCodes  | List<[CountryCode](CountryCode.md)> | ❌       | A list of country codes where the resources are available |
| cpu           | Long                                | ❌       | The number of available CPU cores                         |
| memory        | Long                                | ❌       | The amount of available memory in MB                      |
| storageAmount | Long                                | ❌       | The amount of available storage in bytes                  |
