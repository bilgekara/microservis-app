
eureka server pom gerekirse         
<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-bootstrap</artifactId>
</dependency>

--garip eureka problemii
accountservice doooone

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-elasticsearch</artifactId>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.elasticsearch.client/rest -->
        <dependency>
            <groupId>org.elasticsearch.client</groupId>
            <artifactId>rest</artifactId>
            <version>5.5.3</version>
        </dependency>


spring:
application:
name: ticket-service

datasource:
url: jdbc:mysql://localhost:3306/microservisapp
username: root
password: microservis-app
jpa:
database: mysql
hibernate:
ddl-auto: update
data:
elasticsearch:
repositories:
enabled: false
---
model ->es->ticketmodel
repo -> es

feign client eureka server üzerinden ticket servis account servisteki getById metodunu kullanarak assigneenin validasyonunu gerçekleştircek
assignenın id sini getirip mysqle koyucaz assigneenın adı ve soyadını elastic searche koyacaz
bu yuzden ad soyadla yapılan aramalarla bir nevi ticketları assignee ye gore ad soyadla arama yaparak ticketları listeleme yapbiliyor olucaz



ticket servis account servisi api yoluyla çağırcak
bunun birden fazl yolu var biz feign clientla yapıyo olcaz
feign client ya da eureka server suan jrps implemantesyonu yok
jrksyle yapılabilir(daha fazla performanslı olur) bunu yaparsak load balancer dan kaybediyor olacaz


account servisi birden fazl ayağa kaldırdığımızda eureka server üzerinden roun d robin algoritmasıyla yuke göre birer bire dağıtacak şekilde
birden fazl instanceı api call yapabilecez

tüm apilerin birbirini kolayca implemente edebilmesi için bunu ayru bir modul olarak geliştiricez


service common içerisinde servisler arasında ki kontraktlarım ve
feign clientlar olucak