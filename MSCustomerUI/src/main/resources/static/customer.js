//import axios from axios;
function onInsertRow(row) {
  		let newRowStr = ''
 
  		for (const prop in row) {
    		newRowStr += prop + ': ' + row[prop] + ' \n'
  		}
  		alert('You inserted:\n ' + newRowStr)
	}
 
 
	function onDeleteRow(rowKeys) {
  		alert('You deleted: ' + rowKeys)
	} 

    var RolesGridTable = React.createClass({
        getInitialState: function(){
            return {
            	customers:[]
            }
        },
        componentDidMount:function(){
            $.get(this.props.dataUrl, function(data){
                if(this.isMounted()){
                    this.setState({
                    	customers: data
                    });
                }
            }.bind(this));
        },
        render : function(){

			const options = {
      			afterInsertRow: onInsertRow,
      			afterDeleteRow: onDeleteRow
    		}
 
    		// To delete rows you be able to select rows
    		const selectRowProp = {
      			mode: 'checkbox'
    		}			

           return (<BootstrapTable striped hover  data= {this.state.customers} 
							insertRow={true} 
							deleteRow={true} 
							selectRow={selectRowProp} 
							options={options}>
                <TableHeaderColumn dataField='custNo' isKey>Customer No</TableHeaderColumn>
                <TableHeaderColumn dataField='custName'>Customer Name</TableHeaderColumn>
                <TableHeaderColumn dataField='country'>Country</TableHeaderColumn>
            </BootstrapTable>);
        }
    });
   ReactDOM.render(
        <RolesGridTable dataUrl="/api/hystrix/rest/api/platform/customers/all"/>,
        document.getElementById('root')
    );