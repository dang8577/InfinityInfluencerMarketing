## Requirements

For building and running the application you need:

- [JDK 11](http://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- [Docker](https://www.docker.com/products/docker-desktop/alternatives)
## Assumptions and Performance

- Using h2 database to persist the vocabulary by saving data into a file
- Assuming pre-defined some vocabularies in h2 database. Any added vocabularies will be lost when the container is down
- Only take JSON format
- When program is boost, data will also be moved from database to in-memory store so that the performance of prediction will 
be improved by working with data only on in-memory.
- When adding any new data, the data will be added in-memory to do prediction then after that it will be synchronized to database
for next uses.
- To do so, the performance will be faster when working directly with database.
    
## Running the application locally

- Make package : `mvn clean package`
- Build image : `docker build -t linqia/influencer .`
- run image : `docker run -dp 8050:8080 linqia/influencer`

## Testing

Use Postman or any alternative tools to test GET or POST API endpoints

There are 2 endpoints:
```
- /api/vocab
- /api/prediction
```

Request and Response Format

● /api/vocab

Accepts ```GET request```

Request format
```
/api/vocab
```

Response format
```JSON
{
    "vocab": [
        "#ad",
        "#sponsored",
        "advertisement"
    ]
}
```
● /api/vocab

Accepts ```POST request```
Request format
```JSON
{
      "vocab": [
          "ambassador"
      ]
}
```
Response format
```JSON
{
    "vocab": [
        "#ad",
        "#sponsored",
        "advertisement",
        "ambassador"
    ]
}
```
● /api/prediction
Accepts `POST request`
Request format 1
```JSON
{
  "post_text": "#ad Love these cool toys at #ToysRUs. Go check them out"
}
```


Response format 1
```JSON
{
  "prediction": "sponsored"
}
```
Request format 2
```JSON
{
  "post_text": "My new year resolution is to stay fit and healthy"
}
```
Response format 2
```JSON
{
  "prediction": "non-sponsored"
}
```


