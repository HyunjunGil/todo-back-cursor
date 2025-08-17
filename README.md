# Backend Project

이 프로젝트는 Spring Boot 기반의 백엔드 애플리케이션입니다.

## 기술 스택

- Spring Boot
- Java
- Gradle
- Spring Data JPA
- Spring Security (선택사항)

## 필수 요구사항

- Java 11 이상
- Gradle 7.0 이상

## 설치 및 실행

### 로컬 개발 환경

1. **프로젝트 클론**
   ```bash
   git clone <repository-url>
   cd backend-project
   ```

2. **애플리케이션 실행**
   ```bash
   # Gradle Wrapper 사용
   ./gradlew bootRun
   
   # 또는
   gradle bootRun
   ```

3. **빌드**
   ```bash
   ./gradlew build
   ```

4. **테스트 실행**
   ```bash
   ./gradlew test
   ```

### Docker를 사용한 실행

```bash
# Docker 이미지 빌드
docker build -t backend-app .

# Docker 컨테이너 실행
docker run -p 8080:8080 backend-app
```

## 프로젝트 구조

```
src/
├── main/
│   ├── java/
│   │   └── com/example/backend/
│   │       ├── controllers/    # REST API 컨트롤러
│   │       ├── services/       # 비즈니스 로직
│   │       ├── repositories/   # 데이터 접근 계층
│   │       ├── entities/       # JPA 엔티티
│   │       ├── dto/           # 데이터 전송 객체
│   │       └── config/        # 설정 클래스
│   └── resources/
│       ├── application.yml    # 애플리케이션 설정
│       └── db/               # 데이터베이스 스크립트
└── test/
    └── java/                 # 테스트 코드
```

## API 문서

애플리케이션이 실행되면 다음 URL에서 API 문서를 확인할 수 있습니다:

- Swagger UI: http://localhost:8080/swagger-ui.html
- API Docs: http://localhost:8080/v3/api-docs

## 데이터베이스 설정

`src/main/resources/application.yml` 파일에서 데이터베이스 연결 정보를 설정하세요:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/your_database
    username: your_username
    password: your_password
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

## 환경 변수

다음 환경 변수를 설정할 수 있습니다:

- `SPRING_PROFILES_ACTIVE`: 활성 프로파일 (dev, prod, test)
- `SERVER_PORT`: 서버 포트 (기본값: 8080)
- `DB_URL`: 데이터베이스 URL
- `DB_USERNAME`: 데이터베이스 사용자명
- `DB_PASSWORD`: 데이터베이스 비밀번호

## 배포

### JAR 파일로 배포

```bash
# JAR 파일 생성
./gradlew bootJar

# JAR 파일 실행
java -jar build/libs/backend-project-0.0.1-SNAPSHOT.jar
```

### Docker로 배포

```bash
# Docker 이미지 빌드
docker build -t backend-app .

# Docker Hub에 푸시
docker tag backend-app your-username/backend-app
docker push your-username/backend-app
```

## 모니터링 및 로깅

- Actuator 엔드포인트: http://localhost:8080/actuator
- Health Check: http://localhost:8080/actuator/health
- Metrics: http://localhost:8080/actuator/metrics

## 기여

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 라이선스

이 프로젝트는 MIT 라이선스 하에 배포됩니다.
