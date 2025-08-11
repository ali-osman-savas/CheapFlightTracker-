# UCUZGIDER Backend

Spring Boot 3 + PostgreSQL (Docker) + JPA.

## Hızlı Başlangıç

```bash
# 1) Postgres'i başlat
docker compose up -d

# 2) Uygulamayı çalıştır
./mvnw spring-boot:run   # veya mvn spring-boot:run
```

Uygulama `http://localhost:8080/health` altında.

## Veritabanı
- Host: `localhost:5432`
- DB: `ucuzgider`
- User/Pass: `postgres` / `1234`

## API
- POST `/api/flights/search`
- POST `/api/flights/cheapest-days`
- Swagger UI: `/swagger-ui.html`
