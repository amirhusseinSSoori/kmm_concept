import SwiftUI
import shared

struct ContentView: View {
    @State var simpleCollection = SimpleCollection()
    @State var value: String = ""
   
var body: some View  {
    let getlist = simpleCollection.showList()
        Button("add"){
            simpleCollection.addData(input:value)
            value = ""
        }
        TextField("Enter AnyThing...", text: $value).multilineTextAlignment(.center).lineLimit(1)
    
    List(getlist,id: \.self) {data in
        Text(data).frame(maxWidth: .infinity, alignment: .center).onTapGesture {
            simpleCollection.removeData(input:data)
                 }
                   }
               
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}

