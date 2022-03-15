import SwiftUI
import shared

struct ContentView: View {
    let list = SimpleCollection().str()
 
    
    var body: some View {
        List {
            ForEach(list, id: \.self) { string in
                       Text(string).frame(maxWidth: .infinity, alignment: .center)
                   }
               }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}

