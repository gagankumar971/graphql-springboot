Graphql APIs is exposed on single end point unlike Rest APIs where we have different end point for different api. 
Fields in the response provided from Graphql API is as per user requirement(i.e dynamic in nature).
for eg: At the time of calling graphql api, requester can also decide how many no. of fields would be return from particular domain class.

In this project We have created domains like Order, Item and relationship between these are defined in graphql schema (not in domain class itself).
These domains are queried/inserted from specific graphql api with the use of graphql schema, resolver, mutation etc.

Graphiql is UI display to fire all queryies , mutations of graphql api.

# graphql-springboot
Tool URL: http://localhost:8080/graphiql
API URL: http://localhost:8080/graphql

POST REQUEST 
=============
1. Post Order With Get Detail
------------------------------
mutation{feedOrder(orderId:15,orderNumber:"eoeo22",orderTitle:"",orderText:""
,orderCategory:"",orderStatus:"A",orderTotal:22.0,items:{
  itemId:11111,orderId:10,itemName:"sdfsd",
  itemNumber:"NNN2w3432",itemStatus:"A"
}) {
  orderId
  orderCategory
  orderStatus
  orderTotal
}}


GET REQUESTS
=============
1. Order Search
-----------------
{
  orderSearch(orderId:9){
    orderId
    orderText
    items{
      itemId
      itemName
    }
  }
}

2. Item Search
----------------
{
 itemSearch(itemId:90){
  itemNumber
  itemName
}
}

3. All Items
----------------
{
  allItems{
    itemId
    itemPrice
    itemStatus
  }
}
