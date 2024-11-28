# demo-spring-security
Demo Spring Security - JWT + OAUTH 2

### Features implemented

<table>
  <thead>
    <tr>
      <th>Feature</th>
      <th>Status</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Java 21</td>
      <td><span class="done">✅ Done</span></td>
    </tr>
    <tr>
      <td>Spring Boot v3.x</td>
      <td><span class="done">✅ Done</span></td>
    </tr>
    <tr>
      <td>Spring Security</td>
      <td><span class="done">✅ Done</span></td>
    </tr>
    <tr>
      <td>OAUTH 2</td>
      <td><span class="done">✅ Done</span></td>
    </tr>
    <tr>
      <td>JWT</td>
      <td><span class="done">✅ Done</span></td>
    </tr>
    <tr>
      <td>PostgreSQL v17 (on docker)</td>
      <td><span class="done">✅ Done</span></td>
    </tr>
    <tr>
      <td>Liquibase</td>
      <td><span class="done">✅ Done</span></td>
    </tr>
    <tr>
      <td>MapStruct</td>
      <td><span class="done">✅ Done</span></td>
    </tr>
  </tbody>
</table>

<br />

### Requirements

 - Java 21
 - Docker
 - Generate the private RSA key and public RSA key (see more information in "How to execute")

### How to execute

1 - You need to generate the private RSA key and public RSA key and place it in the "/src/main/resources/keys/" directory. I recommend using OpenSSL. <br/>

Example generating private RSA key (Linux and macOS): <br />
openssl genpkey -algorithm RSA -out private_key.pem -pkeyopt rsa_keygen_bits:4096

Example generating public RSA key (Linux and macOS): <br />
openssl rsa -pubout -in private_key.pem -out public_key.pem

2 - Use the sample collections ("/development/collections/") with Postman.

3 - Run the command "docker compose up" in "/development/docker/"

4 - Run the command "./gradlew clean bootRun" in the root directory.