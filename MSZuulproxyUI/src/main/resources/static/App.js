var tabData = [
  { name: 'Customer', isActive: true },
  { name: 'Order', isActive: false },
];
var Tabs = React.createClass({
  render: function() {
    return (<ul className="nav nav-tabs">
        {tabData.map(function(tab){
          return (
            <Tab data={tab} isActive={this.props.activeTab === tab} handleClick={this.props.changeTab.bind(this,tab)} />
          );
        }.bind(this))}      
      </ul>
    );
  }
});

var Tab = React.createClass({
  render: function() {
    return (
      <li onClick={this.props.handleClick} className={this.props.isActive ? "active" : null}>
        <a href="#">{this.props.data.name}</a>
      </li>
    );
  }
});
var Content = React.createClass({
  render: function() {
    return (
      <div>
        {this.props.activeTab.name === 'Customer' ? 
        		<iframe src="http://localhost:8087/customerui/" width="100%" height="1000px" frameborder="0" className="panel panel-success" scrolling="no"/>
        :null} 
        {this.props.activeTab.name === 'Order' ? 
        		<iframe src="http://localhost:8087/ui/order/" width="100%" height="1000px" frameborder="0" className="panel panel-success" scrolling="no"/>
        :null} 
      </div>
    );
  }
});
var App = React.createClass({
  getInitialState: function() {
    return {
      activeTab: tabData[0]
    }
  }, 
  handleClick: function(tab) {
	  console.log(tab.name);
	  
	  this.setState({activeTab: tab});
	  	  
  },
  render: function() {
    return (
      <div>
        <Tabs activeTab={this.state.activeTab} changeTab={this.handleClick} />
        <Content activeTab={this.state.activeTab} />
      </div>
    );
  }
});
ReactDOM.render(
  <App />,
  document.getElementById('app')
);