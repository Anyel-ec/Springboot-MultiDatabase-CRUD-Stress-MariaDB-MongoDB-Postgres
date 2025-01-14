#!/bin/bash

# Usar variables de entorno pasadas desde el controlador
MONGO_HOST=${MONGO_HOST:-localhost}
MONGO_PORT=${MONGO_PORT:-27018}
MONGO_USER=${MONGO_USER:-admin}
MONGO_PASS=${MONGO_PASS:-adminpassword}
DB_NAME=${MONGO_DB:-northwind}
AUTH_DB=${MONGO_AUTH_DB:-admin}

mongoimport -h $MONGO_HOST --port $MONGO_PORT -u $MONGO_USER -p $MONGO_PASS --authenticationDatabase $AUTH_DB -d $DB_NAME -c category --drop --jsonArray --file src/main/resources/mongo/data/category.json
mongoimport -h $MONGO_HOST --port $MONGO_PORT -u $MONGO_USER -p $MONGO_PASS --authenticationDatabase $AUTH_DB -d $DB_NAME -c customer --drop --jsonArray --file src/main/resources/mongo/data/customer.json
mongoimport -h $MONGO_HOST --port $MONGO_PORT -u $MONGO_USER -p $MONGO_PASS --authenticationDatabase $AUTH_DB -d $DB_NAME -c employee --drop --jsonArray --file src/main/resources/mongo/data/employee.json
mongoimport -h $MONGO_HOST --port $MONGO_PORT -u $MONGO_USER -p $MONGO_PASS --authenticationDatabase $AUTH_DB -d $DB_NAME -c order --drop --jsonArray --file src/main/resources/mongo/data/employeeTerritory.json
mongoimport -h $MONGO_HOST --port $MONGO_PORT -u $MONGO_USER -p $MONGO_PASS --authenticationDatabase $AUTH_DB -d $DB_NAME -c order_detail --drop --jsonArray --file src/main/resources/mongo/data/order_detail.json
mongoimport -h $MONGO_HOST --port $MONGO_PORT -u $MONGO_USER -p $MONGO_PASS --authenticationDatabase $AUTH_DB -d $DB_NAME -c product --drop --jsonArray --file src/main/resources/mongo/data/product.json
mongoimport -h $MONGO_HOST --port $MONGO_PORT -u $MONGO_USER -p $MONGO_PASS --authenticationDatabase $AUTH_DB -d $DB_NAME -c region --drop --jsonArray --file src/main/resources/mongo/data/region.json
mongoimport -h $MONGO_HOST --port $MONGO_PORT -u $MONGO_USER -p $MONGO_PASS --authenticationDatabase $AUTH_DB -d $DB_NAME -c region --drop --jsonArray --file src/main/resources/mongo/data/salesOrder.json
mongoimport -h $MONGO_HOST --port $MONGO_PORT -u $MONGO_USER -p $MONGO_PASS --authenticationDatabase $AUTH_DB -d $DB_NAME -c shipper --drop --jsonArray --file src/main/resources/mongo/data/shipper.json
mongoimport -h $MONGO_HOST --port $MONGO_PORT -u $MONGO_USER -p $MONGO_PASS --authenticationDatabase $AUTH_DB -d $DB_NAME -c supplier --drop --jsonArray --file src/main/resources/mongo/data/supplier.json
mongoimport -h $MONGO_HOST --port $MONGO_PORT -u $MONGO_USER -p $MONGO_PASS --authenticationDatabase $AUTH_DB -d $DB_NAME -c order --drop --jsonArray --file src/main/resources/mongo/data/territory.json
