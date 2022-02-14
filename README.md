## Run
`docker run -dp 8080:8080 dang8577/linqia:latest`

## Assumptions and Performance

- Using h2 database to persist the vocabulary by saving data into a file
- Assuming pre-defined some vocabularies in h2 database. Any added vocabularies will be lost when the container is down
- Only take JSON format
- When program is boost, data will also be moved from database to in-memory store so that the performance of prediction will 
be improved by working with data only on in-memory.
- When adding any new data, the data will be added in-memory to do prediction then after that it will be synchronized to database
for next uses.
- To do so, the performance will be faster when working directly with database.

## Test

1. Get vocab: `curl 0.0.0.0:8080/api/vocab`
1. Add new vocabs `curl -d '{"vocab":["#key_word_1,#key_word_2"]}' 0.0.0.0:8080/api/vocab  -X POST -H "Content-Type: application/json"`
1. Predict `curl -d '{"post_text": "My new year resolution is to stay fit #walmart#ad#laptop and healthy"}' 0.0.0.0:8080/api/prediction  -X POST -H "Content-Type: application/json"`

## Build
- Requirements
    - [Maven 3](https://maven.apache.org)
    - [Docker](https://www.docker.com/products/docker-desktop/alternatives)
- Make package : `mvn clean package`
- Build image : `docker build -t linqia/influencer .`
