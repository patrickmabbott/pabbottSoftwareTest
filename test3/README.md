Basic Front end for Docker management app.

Build Instructions:
-Install npm
-(From within main folder)npm install
-npm run (It's also possible to build for production. But, this is much faster)

Running:
-Make sure the backend is running on localhost port 8080
-(If npm doesn't do this automatically) Browse to http://localhost:3000/
-All running containers should be shown, including their id and name. (Will show as null if no name was provided for container)
-Clicking stop will send a command to stop the specified container (Note that it won't actually disappear until success is returned. In a real project, I would have some form of processing indication for this)