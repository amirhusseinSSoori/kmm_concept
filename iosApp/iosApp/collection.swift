//
//  collection.swift
//  iosApp
//
//  Created by Admin on 3/15/22.
//  Copyright © 2022 orgName. All rights reserved.
//
import SwiftUI
import Foundation

struct collection{
    
    struct GreetView: View {
        let greet = ["hello","good","greeting","bye","hi"]
        var body: some View {
            List {
                ForEach(greet, id: \.self) { string in
                           Text(string).frame(maxWidth: .infinity, alignment: .center)
                       }
                   }
        }
    }
}
