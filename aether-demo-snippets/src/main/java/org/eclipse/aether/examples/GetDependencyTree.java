/*******************************************************************************
 * Copyright (c) 2010, 2013 Sonatype, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Sonatype, Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.aether.examples;

import org.eclipse.aether.RepositorySystem;
import org.eclipse.aether.RepositorySystemSession;
import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.eclipse.aether.collection.CollectRequest;
import org.eclipse.aether.collection.CollectResult;
import org.eclipse.aether.examples.util.Booter;
import org.eclipse.aether.examples.util.ConsoleDependencyGraphDumper;
import org.eclipse.aether.graph.Dependency;
import org.eclipse.aether.graph.DependencyNode;
import org.eclipse.aether.resolution.DependencyRequest;
import org.eclipse.aether.util.graph.visitor.PreorderNodeListGenerator;

/**
 * Collects the transitive dependencies of an artifact.
 */
public class GetDependencyTree
{

    public static void main( String[] args )
        throws Exception
    {
        System.out.println( "------------------------------------------------------------" );
        System.out.println( GetDependencyTree.class.getSimpleName() );

        RepositorySystem system = Booter.newRepositorySystem();

        RepositorySystemSession session = Booter.newRepositorySystemSession( system );

        Artifact artifact = new DefaultArtifact( "com.caocao.billing:billing-api:1.9.9.0" );

//        CollectRequest collectRequest = new CollectRequest();
//        collectRequest.setRoot( new Dependency( artifact, "" ) );
//        collectRequest.setRepositories( Booter.newRepositories( system, session ) );
//
//        CollectResult collectResult = system.collectDependencies( session, collectRequest );
//
//        collectResult.getRoot().accept( new ConsoleDependencyGraphDumper() );
        CollectRequest collectRequest = new CollectRequest();


        collectRequest.setRoot( new Dependency( artifact, "" ) );

        collectRequest.setRepositories( Booter.newRepositories( system, session ) );

        DependencyNode node = system.collectDependencies(session, collectRequest).getRoot();

        DependencyRequest dependencyRequest = new DependencyRequest();

        dependencyRequest.setRoot(node);
        system.resolveDependencies(session, dependencyRequest);

        PreorderNodeListGenerator nlg = new PreorderNodeListGenerator();
        node.accept(nlg);

        System.out.println(nlg.getFiles());


//       CollectResult collectResult = system.collectDependencies( session, collectRequest );

//        collectResult.getRoot().accept( new ConsoleDependencyGraphDumper() );

    }

}
