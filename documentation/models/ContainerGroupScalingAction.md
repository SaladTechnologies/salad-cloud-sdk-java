# ContainerGroupScalingAction

Represents a scaling action configuration for a container group

**Properties**

| Name     | Type   | Required | Description                                                           |
| :------- | :----- | :------- | :-------------------------------------------------------------------- |
| replicas | Long   | ✅       | The number of replicas to scale to during the scheduled period        |
| schedule | String | ✅       | The cron-style schedule string defining when the scaling should occur |
