软件市场应用管理设计
=================

## 前言
### 文档概述
本文给出软件市场项目中应用管理部分设计，包括概要设计，SDK设计以及各模块详细设计。

### 基本概念

- **Application:** 应用程序；
- **Stack:** 这里指应用栈，这里表示已安装应用；
- **Template:** 这里指应用模板，代表一个应用软件，可以有多个版本；
- **Enviroment:** 这里指应用的编排部署环境；
- **Catalog:** 应用目录，每个目录包含多个应用模板。

## 需求分析

### 功能需求
 
1. 支持软件市场分类搜索查看；
2. 支持软件安装、升级、卸载和查询。

## 概要设计

### 领域模型

![app-stack-manager-architecture-model](./app-stack-manager-architecture-model.png)

### 设计框架图

![app-stack-manager-architecture-logical](./app-stack-manager-architecture-logical.png)

### 应用创建流程

![app-stack-manager-flowchart](./app-stack-manager-flowchart.png)


## SDK设计

### 应用管理服务API设计

### ApplicationStackService

```java
interface ApplicationStackService
{

}

```

### Mango SDK 设计
Mango 层SDK 主要以满足需求为主。

```java
/* 应用模板管理*/
class ApplicationTemplate
{
    public static List<ApplicationTemplate> list(ListTemplateOptions option){}
    
    /**
     * 应用模板ID.
     */
    public getSid(){}

    public getDescription(){}

    /**
     * 应用类别.
     */
    public getCategory(){}
    ....
}
```

```java
class ApplicationStack
{
    public static List<ApplicationStack> list(ListStackOptions options){}

    public 

}
```

## 数据库设计

`caas-app-manager-init.sql`
```
CREATE TABLE `caas_enviroment`(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `uuid` varchar(128) NOT NULL,
    `created` datetime DEFAULT NULL,
    `removed` datetime DEFAULT NULL,
    `removeTime` datetime DEFAULT NULL,    
    `name` varchar(255) DEFAULT NULL,
    `description` varchar(1024) DEFAULT NULL,
    `state` varchar(128) NOT NULL COMMENT 'active,inactive,removed',
    `driverId` bigint(20) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_caas_enviroment_uuid`(`uuid`)
);

CREATE TABLE `caas_stack_driver`(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `uuid` varchar(128) NOT NULL,
    `created` datetime DEFAULT NULL,
    `removed` datetime DEFAULT NULL,
    `removeTime` datetime DEFAULT NULL,    
    `mainClass` varchar(255) DEFAULT NULL,
    `data` text,
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_caas_stack_driver_uuid`(`uuid`)
);


CREATE TABLE `caas_stack`(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `uuid` varchar(128) NOT NULL,
    `created` datetime DEFAULT NULL,
    `updated` datetime DEFAULT NULL,
    `removed` datetime DEFAULT NULL,
    `removeTime` datetime DEFAULT NULL,
    `name` varchar(255) DEFAULT NULL,    
    `enviromentId` bigint(20) DEFAULT NULL,
    `state` varchar(255) DEFAULT NULL COMMENT 'creating,running,stopped,removed',
    `versionId` varchar(255) DEFAULT NULL COMMENT 'template version',
    `data` text,
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_caas_stack_driver_uuid`(`uuid`)
);

```