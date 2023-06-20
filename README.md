# 🗒  OnlineShoppingMall 

온라인 쇼핑몰 서비스입니다. 

## 프로젝트 기능 및 설계
- 회원가입 기능
  - 사용자는 회원가입을 할 수 있다. 일반적으로 모든 사용자는 회원가입시 USER 권한 (일반 권한)을 지닌다. 
  - 회원가입시 아이디와 패스워드를 입력받으며, 아이디는 unique 해야한다. 

- 로그인 기능
  - 사용자는 로그인을 할 수 있다. 로그인시 회원가입때 사용한 아이디와 패스워드가 일치해야한다. 

- 상품 목록 조회 기능 
  - 로그인하지 않은 사용자를 포함한 모든 사용자는 상품을 조회할 수 있다. 
  - 게시글은 판매량순으로 기본 정렬되며, 최신순으로도 정렬이 가능하다.
  - 상품 목록 조회시 응답에는 상품 이름, 상품 가격, 재고 여부의 정보가 필요하다.
  - 상품은 종류가 많을수 있으므로 paging 처리를 한다. 

- 특정 상품 조회 기능
  - 로그인하지 않은 사용자를 포함한 모든 사용자는 상품을 조회할 수 있다. 
  - 상품 이름, 상품 가격, 판매자, 판매량, 재고 여부가 조회된다. 

- 장바구니 담기 기능 
  - 로그인한 사용자만 장바구니에 접근이 가능하다.
  - 로그인한 사용자는 권한에 관계 없이 장바구니에 상품을 담을 수 있다. 
  
- 장바구니 목록 조회 기능
  - 장바구니 목록은 최신순으로만 정렬되며, paging 처리를 한다. 
  - 장바구니 목록 조회시에는 상품 이름, 상품 가격, 주문 개수 정보가 필요하다.

- 장바구니 삭제 기능 
  - 로그인한 사용자만 장바구니에 접근이 가능하다.
  - 로그인한 사용자는 권한에 관계 없이 장바구니에서 상품을 삭제할 수 있다.  

- 장바구니 결제 기능
  - 로그인한 사용자만 장바구니에 접근이 가능하다.
  - 결제가 되면 판매량이 주문 수 만큼 증가하고, 상품은 장바구니에서 사라진다.   

## ERD 
![image](https://github.com/rui27sui/OnlineShoppingMall/assets/125226054/3baa56b2-6747-4564-982c-eefda98ab2c1)


## 구성 환경
Spring boot 2.7.x (JDK11)
Gradle
Junit5
H2 Database
JPA
Mockito
Lombok



## Trouble Shooting
[go to the trouble shooting section](doc/TROUBLE_SHOOTING.md)

# shoppingmall
