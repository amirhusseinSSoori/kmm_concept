import SwiftUI
import shared

struct ContentView: View {
    @State var list = SimpleCollection().showList()
    @State var value: String = ""
   
var body: some View  {
 
        Button("add"){
            list.append(value)
            value = ""
        }
        TextField("Enter AnyThing...", text: $value).multilineTextAlignment(.center).lineLimit(1)
    
    List(list.indices,id: \.self) {index in
        Text(list[index]).frame(maxWidth: .infinity, alignment: .center).onTapGesture {
            list.remove(at: index)
            
                 }
                   }
               
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}

