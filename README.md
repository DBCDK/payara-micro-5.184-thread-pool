# payara-micro managed executor service thread pool

According to the `--rootdir` dump of a paraya micro instance the thread pool for


    <managed-executor-service keep-alive-seconds="300" core-pool-size="2" task-queue-capacity="20000" object-type="system-all" maximum-pool-size="200" hung-after-seconds="300" jndi-name="concurrent/__defaultManagedExecutorService" long-running-tasks="true"></managed-executor-service>

Core-size of the pool is 2 and should scale to 200.

However this example with 10 tasks added to the default mes, runs only 2 in parallel

`mvn package payara-micro:start`

You would expect output from more that 2 threads at the time.
