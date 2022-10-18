run:
		docker-compose up -d --build ./drone-feeder/gradlew quarkusDev

stop:
		docker-compose down --remove-orphans
