CREATE DATABASE  IF NOT EXISTS `healthtracker-db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `healthtracker-db`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: aa7449tkftxxy3.c4ccu8atjuy7.us-west-2.rds.amazonaws.com    Database: healthtracker-db
-- ------------------------------------------------------
-- Server version	5.6.27-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `birthDate` date DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `height` double DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`,`userName`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `userName_UNIQUE` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'asd','','2016-11-04',NULL,0,0,''),(2,'zxc','','2016-11-02',NULL,0,0,''),(3,'qwe','','2016-11-01',NULL,0,0,''),(4,'wer','','2016-11-04',NULL,0,0,''),(5,'suzan.uskudarli','suzan uskudarli','1974-02-20','Female',1.75,62,''),(6,'b','Ozan Yarc&#305;','2016-11-03','Male',170,78,'ozanyarci@gmail.com'),(7,'c','','2016-11-02',NULL,0,0,''),(9,'d','','2016-11-03',NULL,2,78,''),(10,'dfg','','2016-11-02',NULL,0,0,''),(11,'p','ozan','2016-11-03','Male',2,80,'asd@example.com'),(12,'test','ozan','2016-11-10','Male',2,80,'ozanyarci@hotmail.com'),(13,'bahad&#305;r','bahad&#305;r','2016-11-22','Male',2,80,'ozanyarci@hotmail.com'),(14,'bahadir','bahadir','2016-11-01','Male',2,80,'ozanyarci@hotmail.com'),(15,'&#305;','','2016-11-04',NULL,0,0,''),(16,'q','q','2016-11-04',NULL,0,0,''),(17,'ibrahim','','2016-11-10',NULL,0,0,''),(18,'ibrahim2','ibrahim','2016-11-10','Male',2,1,'ozanyarci@hotmail.com'),(19,'ibrahim3','ibrahim','2016-11-03','Male',2,2,''),(20,'ibrahim4','ibrahim','2016-11-03','Male',2,0,''),(21,'ibrahim5','ibrahim','2016-11-02','Male',0,2,''),(22,'l','','2016-11-04',NULL,1,79,''),(23,'Ozan Yarc&#305;','Ozan Yarc&#305;','1989-02-08','Male',2,76,'ozanyarci@gmail.com'),(24,'Ozan Yarci','Ozan Yarc&#305;','2016-12-01','Male',2,76,'ozanyarci@gmail.com'),(25,'OzanYarci','Ozan Yarc&#305;','2016-12-01','Male',2,76,'ozanyarci@gmail.com'),(26,'Ozan Yarci JR','Ozan Yarci','2016-12-02','Male',2,76,'ozanyarci@gmail.com'),(27,'lkj','l','2016-12-01',NULL,2,79,''),(28,'Jack Sparrow','Jack Sparrow','1978-01-01','Male',1.8,79,'jack.sparrow@gmail.com'),(29,'f85aa2de-6651-46e0-b8c9-a127062af00b','Ozan','2016-12-11','Male',1.8,80,'ozanyarci@gmail.com'),(30,'d41f92f0-8f28-49ec-88aa-a5eea0657ba8','Ozan','2016-12-11','Male',1.8,80,'ozanyarci@gmail.com'),(31,'f61d8874-d3e1-4d1d-a9b0-206310482e94','Ozan','2016-12-11','Male',1.8,80,'ozanyarci@gmail.com'),(32,'f7185da3-beca-40a1-814e-482322b48135','Ozan','2016-12-11','Male',1.8,80,'ozanyarci@gmail.com'),(33,'c5ae6ae1-ebff-4863-8fcf-e67d91fe2bb8','Ozan','2016-12-11','Male',1.8,80,'ozanyarci@gmail.com'),(34,'1ccf5fcc-8754-42f5-beb1-e943d89e87f0','Ozan','2016-12-18','Male',1.8,80,'ozanyarci@gmail.com'),(35,'2f646b68-dfbd-45e7-8b5b-4a10cb9a29f1','Ozan','2016-12-18','Male',1.8,80,'ozanyarci@gmail.com');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customerhistory`
--

DROP TABLE IF EXISTS `customerhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customerhistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `birthDate` date DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `height` double DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `currentTime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customerhistory`
--

LOCK TABLES `customerhistory` WRITE;
/*!40000 ALTER TABLE `customerhistory` DISABLE KEYS */;
INSERT INTO `customerhistory` VALUES (3,'d','2016-11-03',NULL,0,0,'2016-11-13 21:08:22'),(4,'d','2016-11-03',NULL,100,0,'2016-11-13 21:09:24'),(5,'d','2016-11-03',NULL,2,78,'2016-11-13 21:23:41'),(6,'d','2016-11-03',NULL,2,78,'2016-11-13 21:25:23'),(7,'suzan.uskudarli','2016-11-02','Female',1.75,80,'2016-11-13 21:30:31'),(8,'suzan.uskudarli','2016-11-02','Female',1.75,81,'2016-11-13 21:31:17'),(9,'dfg','2016-11-02',NULL,0,0,'2016-11-13 21:45:26'),(10,'p','2016-11-03','Male',2,80,'2016-11-15 18:09:52'),(11,'test','2016-11-10','Male',2,80,'2016-11-22 18:14:36'),(12,'bahad&#305;r','2016-11-22','Male',2,80,'2016-11-22 18:41:51'),(13,'bahadir','2016-11-01','Male',2,80,'2016-11-22 18:43:10'),(14,'suzan.uskudarli','2016-11-02','Female',1.75,81,'2016-11-26 17:04:14'),(15,'suzan.uskudarli','2016-11-03','Female',1.75,81,'2016-11-26 17:04:25'),(16,'suzan.uskudarli','2016-11-03','Female',1.75,81,'2016-11-26 17:04:45'),(17,'suzan.uskudarli','2016-11-03','Female',1.75,81,'2016-11-26 17:04:51'),(18,'suzan.uskudarli','2016-11-03','Female',1.75,81,'2016-11-26 17:04:55'),(19,'suzan.uskudarli','2016-11-03','Female',1.75,81,'2016-11-26 17:05:17'),(20,'&#305;','2016-11-04',NULL,0,0,'2016-11-26 17:06:13'),(21,'q','2016-11-04',NULL,0,0,'2016-11-26 17:07:41'),(22,'ibrahim','2016-11-10',NULL,0,0,'2016-11-26 17:08:14'),(23,'ibrahim2','2016-11-10','Male',2,1,'2016-11-26 17:09:36'),(24,'ibrahim3','2016-11-03','Male',2,2,'2016-11-26 17:10:12'),(25,'ibrahim4','2016-11-03','Male',2,0,'2016-11-26 17:10:45'),(26,'ibrahim5','2016-11-02','Male',0,2,'2016-11-26 17:11:19'),(27,'l','2016-11-04',NULL,1.2,78.9,'2016-11-26 17:19:30'),(28,'suzan.uskudarli','2016-11-03','Female',1.75,82,'2016-12-03 16:40:22'),(29,'Ozan Yarc&#305;','1989-02-08','Male',1.7,76,'2016-12-03 17:31:33'),(30,'Ozan Yarci','2016-12-01','Male',1.7,76,'2016-12-03 17:36:03'),(31,'OzanYarci','2016-12-01','Male',1.7,76,'2016-12-03 17:37:59'),(32,'Ozan Yarci JR','2016-12-02','Male',1.7,76,'2016-12-03 17:40:03'),(33,'lkj','2016-12-01',NULL,1.7,78.8,'2016-12-03 18:20:30'),(34,'suzan.uskudarli','2016-11-03','Female',1.75,82,'2016-12-03 18:27:21'),(35,'suzan.uskudarli','2016-11-03','Female',1.75,70,'2016-12-07 22:21:41'),(36,'Jack Sparrow','1978-01-01','Male',1.8,80,'2016-12-11 11:54:52'),(37,'Jack Sparrow','1978-01-01','Male',1.8,79,'2016-12-11 16:38:35'),(38,'suzan.uskudarli','1974-02-20','Female',1.75,60,'2016-12-18 14:24:29'),(39,'suzan.uskudarli','1974-02-20','Female',1.75,62,'2016-12-18 18:16:17');
/*!40000 ALTER TABLE `customerhistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise`
--

DROP TABLE IF EXISTS `exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exercise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `exercise` varchar(45) NOT NULL,
  `130lbs` double DEFAULT NULL,
  `155lbs` double DEFAULT NULL,
  `180lbs` double DEFAULT NULL,
  `205lbs` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise`
--

LOCK TABLES `exercise` WRITE;
/*!40000 ALTER TABLE `exercise` DISABLE KEYS */;
INSERT INTO `exercise` VALUES (1,'Aerobics, general',384,457,531,605),(2,'Aerobics, high impact',413,493,572,651),(3,'Aerobics, low impact',295,352,409,465),(4,'Aerobics, step aerobics',502,598,695,791),(5,'Archery',207,246,286,326),(6,'Backpacking, Hiking with pack',413,493,572,651),(7,'Badminton',266,317,368,419),(8,'Bagging grass, leaves',236,281,327,372),(9,'Bakery, light effort',148,176,204,233),(10,'Ballet, twist, jazz, tap',266,317,368,419),(11,'Ballroom dancing, fast',325,387,449,512),(12,'Ballroom dancing, slow',177,211,245,279),(13,'Basketball game, competitive',472,563,654,745),(14,'Basketball, playing, non game',354,422,490,558),(15,'Basketball, shooting baskets',266,317,368,419),(16,'Basketball, wheelchair',384,457,531,605),(17,'Bathing dog',207,246,286,326),(18,'Bird watching',148,176,204,233),(19,'Bowling',177,211,245,279),(20,'Boxing, in ring',708,844,981,1117),(21,'Boxing, punching bag',354,422,490,558),(22,'Boxing, sparring',531,633,735,838),(23,'Calisthenics, light, pushups, situps…',207,246,286,326),(24,'Calisthenics, fast, pushups, situps…',472,563,654,745),(25,'Canoeing, camping trip',236,281,327,372),(26,'Canoeing, rowing, light',177,211,245,279),(27,'Canoeing, rowing, moderate',413,493,572,651),(28,'Canoeing, rowing, vigorous',708,844,981,1117),(29,'Carpentry, general',207,246,286,326),(30,'Carrying 16 to 24 lbs, upstairs',354,422,490,558),(31,'Carrying 25 to 49 lbs, upstairs',472,563,654,745),(32,'Carrying heavy loads',472,563,654,745),(33,'Carrying infant, level ground',207,246,286,326),(34,'Carrying infant, upstairs',295,352,409,465),(35,'Carrying moderate loads upstairs',472,563,654,745),(36,'Carrying small children',177,211,245,279),(37,'Children\'s games, hopscotch...',295,352,409,465),(38,'Circuit training, minimal rest',472,563,654,745),(39,'Cleaning gutters',295,352,409,465),(40,'Cleaning, dusting',148,176,204,233),(41,'Climbing hills, carrying up to 9 lbs',413,493,572,651),(42,'Climbing hills, carrying 10 to 20 lb',443,528,613,698),(43,'Climbing hills, carrying 21 to 42 lb',472,563,654,745),(44,'Climbing hills, carrying over 42 lb',531,633,735,838),(45,'Coaching: football,basketball,soccer',236,281,327,372),(46,'Coal mining, general',354,422,490,558),(47,'Construction, exterior, remodeling',325,387,449,512),(48,'Crew, sculling, rowing, competition',708,844,981,1117),(49,'Cricket (batting, bowling)',295,352,409,465),(50,'Croquet',148,176,204,233),(51,'Cross country snow skiing, slow',413,493,572,651),(52,'Cross country skiing, moderate',472,563,654,745),(53,'Cross country skiing, racing',826,985,1144,1303),(54,'Cross country skiing, uphill',974,1161,1348,1536),(55,'Cross country skiing, vigorous',531,633,735,838),(56,'Curling',236,281,327,372),(57,'Cycling, <10mph, leisure bicycling',236,281,327,372),(58,'Cycling, >20mph, racing',944,1126,1308,1489),(59,'Cycling, 10-11.9mph, light',354,422,490,558),(60,'Cycling, 12-13.9mph, moderate',472,563,654,745),(61,'Cycling, 14-15.9mph, vigorous',590,704,817,931),(62,'Cycling, 16-19mph, very fast, racing',708,844,981,1117),(63,'Cycling, mountain bike, bmx',502,598,695,791),(64,'Darts (wall or lawn)',148,176,204,233),(65,'Diving, springboard or platform',177,211,245,279),(66,'Downhill snow skiing, moderate',354,422,490,558),(67,'Downhill snow skiing, racing',472,563,654,745),(68,'Electrical work, plumbing',207,246,286,326),(69,'Farming, baling hay, cleaning barn',472,563,654,745),(70,'Farming, chasing cattle on horseback',236,281,327,372),(71,'Farming, feeding horses or cattle',266,317,368,419),(72,'Farming, feeding small animals',236,281,327,372),(73,'Farming, grooming animals',354,422,490,558),(74,'Fencing',354,422,490,558),(75,'Fire fighter, climbing ladder, full gear',649,774,899,1024),(76,'Fire fighter, hauling hoses on ground',472,563,654,745),(77,'Fishing from boat, sitting',148,176,204,233),(78,'Fishing from riverbank, standing',207,246,286,326),(79,'Fishing from riverbank, walking',236,281,327,372),(80,'Fishing in stream, in waders',354,422,490,558),(81,'Fishing, general',177,211,245,279),(82,'Fishing, ice fishing',118,141,163,186),(83,'Flying airplane (pilot)',118,141,163,186),(84,'Football or baseball, playing catch',148,176,204,233),(85,'Football, competitive',531,633,735,838),(86,'Football, touch, flag, general',472,563,654,745),(87,'Forestry, ax chopping, fast',1003,1196,1389,1582),(88,'Forestry, ax chopping, slow',295,352,409,465),(89,'Forestry, carrying logs',649,774,899,1024),(90,'Forestry, sawing by hand',413,493,572,651),(91,'Forestry, trimming trees',531,633,735,838),(92,'Frisbee playing, general',177,211,245,279),(93,'Frisbee, ultimate frisbee',472,563,654,745),(94,'Gardening, general',236,281,327,372);
/*!40000 ALTER TABLE `exercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `food` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `foodName` varchar(100) NOT NULL,
  `amount` varchar(45) DEFAULT NULL,
  `foodEatenDate` date DEFAULT NULL,
  `meal` varchar(45) DEFAULT NULL,
  `amountType` varchar(45) DEFAULT NULL,
  `userName` varchar(45) NOT NULL,
  `ndbno` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES (6,'DEL MONTE, MANDARIN ORANGES IN ORANGE FLAVORED GEL, UPC: 024000051985','100','2016-11-30','Breakfast','gr','suzan.uskudarli','45079088'),(7,'Babyfood, carrots, toddler','2','2016-11-30','Breakfast','oz','suzan.uskudarli','42316'),(8,'BREYERS, DARK CHOCOLATE ICE CREAM WITH PEANUT BUTTER SWIRL, CHOCOLATE PEANUT BUTTER, UPC: 0775676033','100','2016-11-30','Lunch','gr','suzan.uskudarli','45093440'),(9,'Fast foods, submarine sandwich, steak and cheese on white bread with cheese, lettuce and tomato','1','2016-11-30','Dinner','inch sub','suzan.uskudarli','21160'),(10,'Egg, yolk, dried','100','2016-12-02','Breakfast','gr','suzan.uskudarli','01137'),(11,'Egg, yolk, dried','2','2016-12-02','Breakfast','cup, sifted','suzan.uskudarli','01137'),(12,'KLONDIKE, REESE\'S, BARS, REESE\'S PEANUT BUTTER LIGHT* ICE CREAM WITH REESE\'S PEANUT BUTTER CUP PIECE','200','2016-12-02','Breakfast','gr','suzan.uskudarli','45092057'),(13,'KLONDIKE, REESE\'S, BARS, REESE\'S PEANUT BUTTER LIGHT* ICE CREAM WITH REESE\'S PEANUT BUTTER CUP PIECE','3','2016-12-02','Breakfast','g','suzan.uskudarli','45092057'),(14,'MANTIA\'S, ENRICHED EGG NOODLE PRODUCT, WIDE EGG NOODLES, UPC: 051933105508','2','2016-12-02','Breakfast','gr','suzan.uskudarli','45051195'),(15,'MANTIA\'S, ENRICHED EGG NOODLE PRODUCT, WIDE EGG NOODLES, UPC: 051933105508','2','2016-12-02','Dinner','cup','suzan.uskudarli','45051195'),(16,'GRANDMA\'S, HOMESTYLE PEANUT BUTTER BIG COOKIE, PEANUT BUTTER, UPC: 028400440875','2','2016-12-02','Breakfast','g','suzan.uskudarli','45021118'),(17,'KROGER, NATURAL & ARTIFICIAL BUTTER FLAVORED POPCORN, ORIGINAL BUTTER, UPC: 011110799029','3','2016-12-02','Other','Tbsp','suzan.uskudarli','45106774'),(18,'FAT-FREE & CHOLESTEROL-FREE EGG MAKERS, LIQUID EGG PRODUCT, UPC: 078742118178','100','2016-12-03','Breakfast','gr','suzan.uskudarli','45052364'),(19,'Egg, yolk, dried','1','2016-12-03','Breakfast','cup, sifted','suzan.uskudarli','01137'),(20,'MEIJER, ORANGE JUICE, ORANGE, UPC: 041250646310','2','2016-12-03','Breakfast','cup','suzan.uskudarli','45040119'),(21,'MEIJER, APPLE JELLY, APPLE, UPC: 041250964353','3','2016-12-03','Dinner','Tbsp','suzan.uskudarli','45042458'),(22,'HARRIS TEETER, ORANGE MARMALADE, ORANGE, UPC: 072036200266','200','2016-12-03','Lunch','gr','Ozan Yarci JR','45028646'),(23,'KROGER, MANDARIN ORANGES, LITE, PEELED SEGMENTS IN MANDARIN ORANGE JUICE, UPC: 011110832535','3','2016-12-04','Breakfast','cup','suzan.uskudarli','45092792'),(24,'BREYERS, REESES PEANUT BUTTER ICE CREAM WITH REESE\'S PEANUT BUTTER CUP PIECES AND A FUDGE SWIRL, UPC','100','2016-12-04','Breakfast','gr','suzan.uskudarli','45094132'),(25,'Cheese, cheddar','2','2016-12-04','Breakfast','cup, diced','suzan.uskudarli','01009'),(26,'CREAMSICLE, THE ORIGINAL CREAM BARS, ORANGE, VANILLA FLAVORED LOW FAT ICE CREAM BARS COATED WITH ORA','2','2016-12-07','Breakfast','g','suzan.uskudarli','45085935'),(27,'TILLAMOOK, GARLIC WHITE CHEDDAR NATURAL CHEESE, GARLIC, WHITE CHEDDAR, UPC: 072830033473','1','2016-12-08','Lunch','oz','suzan.uskudarli','45095518'),(28,'ALDEN\'S, ORGANIC ORANGE SHERBET, ORANGE, UPC: 072609033161','1','2016-12-08','Breakfast','g','suzan.uskudarli','45003424'),(29,'BREYERS, FROZEN DAIRY DESSERT, NO SUGAR ADDED, BUTTER PECAN, BUTTER PECAN FLAVOR WITH OTHER NATURAL ','1','2016-12-11','Breakfast','cup','suzan.uskudarli','45093454'),(30,'MANDARIN ORANGES MANDARIN ORANGES IN LIGHT SYRUP, UPC: 024000011484','100','2016-12-11','Lunch','gr','suzan.uskudarli','45058161'),(31,'EGG MATES MADE WITH REAL EGG WHITES, UPC: 011213859682','2','2016-12-11','Breakfast','Tbsp','Jack Sparrow','45082049'),(32,'MARGIE\'S, BANANA SYRUP, BANANA, UPC: 716418957361','2','2016-12-11','Breakfast','cup','Jack Sparrow','45011447'),(33,'Babyfood, juice, orange','1','2016-12-11','Breakfast','bottle Heinz Strained (4 fl oz)','Jack Sparrow','03172'),(34,'ALDEN\'S, ORGANIC ORANGE SHERBET, ORANGE, UPC: 072609033161','200','2016-12-13','Breakfast','gr','Jack Sparrow','45003424'),(35,'CEDARLANE, GREEN CHILE, CHEESE & RANCHERO SAUCE EGG WHITE OMELETTE, UPC: 038794994915','2','2016-12-13','Lunch','g','Jack Sparrow','45031509'),(36,'WEIS QUALITY, MAC & CHEESE BLEND SHREDDED CHEESE, UPC: 041497083077','2','2016-12-18','Breakfast','cup','suzan.uskudarli','45051010');
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`,`uname`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `uname_UNIQUE` (`uname`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (7,'suzan.uskudarli','cc175b9c0f1b6a831c399e269772661'),(8,'b','92eb5ffee6ae2fec3ad71c777531578f'),(11,'c','4a8a8f09d37b73795649038408b5f33'),(12,'d','8277e091d75195b448797616e091ad'),(14,'dfg','38d735571b6f376ee49852904319c1'),(15,'p','83878c91171338902efe0fb97a8c47a'),(16,'test','98f6bcd4621d373cade4e832627b4f6'),(17,'bahad&#305;r','7815696ecbf1c96e6894b779456d33e'),(18,'bahadir','7815696ecbf1c96e6894b779456d33e'),(19,'&#305;','9d3c23cbb4706779f9cbb254344583'),(20,'q','7694f4a66316e53c8cdd9d9954bd611d'),(21,'ibrahim','f1c083e61b32d3a9be76bc21266b648'),(23,'ibrahim2','f1c083e61b32d3a9be76bc21266b648'),(24,'ibrahim3','f1c083e61b32d3a9be76bc21266b648'),(25,'ibrahim4','f1c083e61b32d3a9be76bc21266b648'),(26,'ibrahim5','f1c083e61b32d3a9be76bc21266b648'),(27,'l','2db95e8e1a9267b7a1188556b213b33'),(29,'m','6f8f57715090da2632453988d9a1501b'),(30,'Ozan Yarc&#305;','94eef9c11e4911feb785853fbb68a315'),(31,'Ozan Yarci','94eef9c11e4911feb785853fbb68a315'),(32,'OzanYarci','94eef9c11e4911feb785853fbb68a315'),(34,'Ozan Yarci JR','94eef9c11e4911feb785853fbb68a315'),(35,'lkj','cc175b9c0f1b6a831c399e269772661'),(36,'Jack Sparrow','4ff9fc6e4e5d5f59c4f2134a8cc96d1'),(37,'165e2ce5-591b-4158-b0ec-2eba27c73a03','81dc9bdb52d04dc2036dbd8313ed055'),(39,'625ec9ff-2ebe-4d4f-af81-040c95550b80','81dc9bdb52d04dc2036dbd8313ed055'),(41,'f1c5a09e-b6cf-4257-b61f-7755330175b6','81dc9bdb52d04dc2036dbd8313ed055'),(43,'d4efa2a6-7265-404e-a7e0-e6c5cc03cad5','81dc9bdb52d04dc2036dbd8313ed055'),(45,'d135ba05-4380-4287-836b-559ae28d348f','81dc9bdb52d04dc2036dbd8313ed055'),(47,'5c13cf66-96b4-44df-a76a-c1c02945fd4f','81dc9bdb52d04dc2036dbd8313ed055');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sport`
--

DROP TABLE IF EXISTS `sport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `exercise` varchar(45) NOT NULL,
  `caloriesBurnt` double DEFAULT NULL,
  `duration` bigint(20) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `userName` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport`
--

LOCK TABLES `sport` WRITE;
/*!40000 ALTER TABLE `sport` DISABLE KEYS */;
INSERT INTO `sport` VALUES (1,'Bird watching',0,60,'2016-12-07','suzan.uskudarli'),(2,'Cricket (batting, bowling)',409,60,'2016-12-07','suzan.uskudarli'),(3,'Canoeing, camping trip',654,120,'2016-12-07','suzan.uskudarli'),(4,'Cricket (batting, bowling)',352,60,'2016-12-07','suzan.uskudarli'),(5,'Fire fighter, hauling hoses on ground',563,60,'2016-12-08','suzan.uskudarli'),(6,'Aerobics, general',457,60,'2016-12-08','suzan.uskudarli'),(7,'Basketball, shooting baskets',736,120,'2016-12-11','Jack Sparrow'),(8,'Bowling',122.5,30,'2016-12-11','Jack Sparrow'),(9,'Boxing, in ring',981,60,'2016-12-13','Jack Sparrow'),(10,'Cleaning, dusting',74,30,'2016-12-18','suzan.uskudarli');
/*!40000 ALTER TABLE `sport` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-18 19:40:55
