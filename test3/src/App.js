import React, { Component } from 'react';
import { List, Button, Icon, Card, Header, Label } from 'semantic-ui-react';
import 'semantic-ui-css/semantic.min.css'

class App extends Component {

  state = {
      runningContainers : []
  }

  onClickStop = (containerId) => {
      const { runningContainers} = this.state;
      fetch("http://localhost:8080/api/stop",
      {
        method : 'POST',
        mode: 'cors',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: `contid=${containerId}`
    })
    .then( () => {
        const updatedRunningContainers = runningContainers
        .filter( entry => {
            return entry.containerId !== containerId;
        });
        this.setState( { runningContainers : updatedRunningContainers })
    })
  }

  componentDidMount() {
      //todo: Obviously, production code would have error handling.
      fetch("http://localhost:8080/api/runningconts")
      .then( response => response.json())
      .then( data => {
        this.setState( { runningContainers : data })
      })
  }

  render() {
      const { runningContainers } = this.state;
    return (
        <div>
            <Header as='h1'>Running Containers</Header>
            <List>
                {
                    runningContainers.map( container => {
                        return (
                        <List.Item key={container.containerId}>
                            
                            <Card>
                                <Card.Content>
                                    <Card.Header>{container.containerId}</Card.Header>
                                    <Card.Description><Label>Name:</Label> {container.containerName}</Card.Description>
                                </Card.Content>
                                <Card.Content>
                                    <Button onClick={() => this.onClickStop(container.containerId)} icon><Icon name='stop'/>stop</Button>
                                </Card.Content>
                            </Card></List.Item>
                        )
                    })
                }
            </List>
        </div>
    );
  }
}

export default App;